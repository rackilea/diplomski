import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.sql.Date;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v1CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

public class SelfSignedCertificateGenerator {

    private static final JcaX509CertificateConverter CONVERTER = new JcaX509CertificateConverter()
        .setProvider(new BouncyCastleProvider());

    private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";

    private static final X500Name ISSUER = new X500Name(new X500Principal("CN=Stupid CA Certificate").getName());
    private static final X500Name SUBJECT = ISSUER;
    private static final Date NOT_AFTER = Date.valueOf("3000-01-01");
    private static final Date NOT_BEFORE = Date.valueOf("2000-01-01");
    private static final BigInteger SERIAL = new BigInteger("1");

    public static Certificate[] getCerts(KeyPair keys) {
        return new Certificate[] { getCertificate(keys) };
    }

    private static X509Certificate getCertificate(KeyPair keys) {
        try {
            X509v1CertificateBuilder certificateBuilder = getCertificateBuilder(keys.getPublic());
            X509CertificateHolder certificateHolder = certificateBuilder.build(getSigner(keys));
            return CONVERTER.getCertificate(certificateHolder);
        } catch (CertificateException e) {
            throw new RuntimeException(e);
        }
    }

    private static X509v1CertificateBuilder getCertificateBuilder(PublicKey publicKey) {
        return new X509v1CertificateBuilder(ISSUER, SERIAL, NOT_BEFORE, NOT_AFTER, SUBJECT, getPublicKeyInfo(publicKey));
    }

    private static SubjectPublicKeyInfo getPublicKeyInfo(PublicKey publicKey) {
        if (!(publicKey instanceof RSAPublicKey))
            throw new RuntimeException("publicKey is not an RSAPublicKey");

        RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;

        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(new RSAKeyParameters(false, rsaPublicKey
                .getModulus(), rsaPublicKey.getPublicExponent()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ContentSigner getSigner(KeyPair keys) {
        try {
            return new JcaContentSignerBuilder(SIGNATURE_ALGORITHM).setProvider(new BouncyCastleProvider()).build(
                keys.getPrivate());
        } catch (OperatorCreationException e) {
            throw new RuntimeException(e);
        }
    }
}