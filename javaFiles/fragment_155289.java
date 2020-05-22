import org.bouncycastle.asn1.*;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.*;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;
import org.jscep.client.Client;
import org.jscep.client.DefaultCallbackHandler;
import org.jscep.client.EnrollmentResponse;
import org.jscep.client.verification.CachingCertificateVerifier;
import org.jscep.client.verification.CertificateVerifier;
import org.jscep.client.verification.ConsoleCertificateVerifier;
import org.jscep.client.verification.OptimisticCertificateVerifier;
import org.jscep.transport.request.GetCaCapsRequest;
import org.jscep.transport.request.GetCaCertRequest;
import org.jscep.transport.request.GetNextCaCertRequest;
import org.jscep.transport.response.Capabilities;
import org.jscep.transport.response.Capability;

import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.x500.X500Principal;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.security.*;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class MainClient {
    public static void main(String args[]) throws Exception{

        URL url = new URL("http://host/certsrv/mscep_admin/mscep.dll");

        DefaultCallbackHandler handler = new DefaultCallbackHandler(new OptimisticCertificateVerifier());
        Client client = new Client(url, handler);
        Authenticator.setDefault (new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("username", "password".toCharArray());
            }
        });

        Capabilities caps = client.getCaCapabilities("CA name");

        JcaContentSignerBuilder signerBuilder;
        if (caps.contains(Capability.SHA_1)) {
            signerBuilder = new JcaContentSignerBuilder("SHA1withRSA");
        } else {
            signerBuilder = new JcaContentSignerBuilder("MD5withRSA");
        }

        KeyPair idPair = KeyPairGenerator.getInstance("RSA").genKeyPair();
        X500Name issuer = new X500Name("CN=entity name");
        BigInteger serial = new BigInteger(16, new SecureRandom());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date notBefore = cal.getTime();
        cal.add(Calendar.DATE, 2);
        Date notAfter = cal.getTime();
        X500Name subject = issuer;
        PublicKey publicKey = idPair.getPublic();
        JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(issuer, serial, notBefore, notAfter, subject, publicKey);
        X509CertificateHolder idHolder = certBuilder.build(signerBuilder.build(idPair.getPrivate()));
        X509Certificate id = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(idHolder.getEncoded()));

        X500Name entityName = new X500Name("CN=entity name");
        KeyPair entityPair = KeyPairGenerator.getInstance("RSA").genKeyPair();
        SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo
                .getInstance(entityPair.getPublic().getEncoded());
        PKCS10CertificationRequestBuilder csrBuilder = new PKCS10CertificationRequestBuilder(entityName, publicKeyInfo);

        csrBuilder.addAttribute(
                PKCSObjectIdentifiers.pkcs_9_at_challengePassword,
                new DERPrintableString(new String("password".toCharArray())));
        ContentSigner signer = signerBuilder.build(entityPair.getPrivate());
        PKCS10CertificationRequest csr = csrBuilder.build(signer);

        EnrollmentResponse response = client.enrol(id, idPair.getPrivate(), csr,"CA name");
        if (response.isFailure()) {
            System.out.println("Failed!");
        } else if (response.isPending()) {
            System.out.println("Pending!");

            X500Principal entityPrincipal = new X500Principal(
                    entityName.getEncoded());

            response = client.poll(id, idPair.getPrivate(), entityPrincipal,
                    response.getTransactionId(),"CA name");
        } else if (response.isSuccess()) {
            System.out.println("Success!");

            CertStore store = response.getCertStore();
            Collection<? extends Certificate> certs = store
                    .getCertificates(null);
            Certificate[] chain = new Certificate[certs.size()];

            int i = 0;
            for (Certificate certificate : certs) {
                chain[i++] = certificate;
            }

            FileOutputStream os = new FileOutputStream("cert.cer");
            os.write("-----BEGIN CERTIFICATE-----\n".getBytes("US-ASCII"));
            os.write(Base64.encodeBase64(chain[0].getEncoded(), true));
            os.write("-----END CERTIFICATE-----\n".getBytes("US-ASCII"));
            os.close();
            System.out.println("Certificate : "+chain[0].toString());

            KeyStore entityStore = KeyStore.getInstance("JKS");
            entityStore.load(null, null);
            entityStore.setKeyEntry("entity", entityPair.getPrivate(),
                    "secret".toCharArray(), chain);
            entityStore.store(new ByteArrayOutputStream(),
                    "secret".toCharArray());



        }
    }
}