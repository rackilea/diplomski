import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.Security;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import static org.junit.Assert.assertEquals;

public class Ed25519JCA {

    private static final Logger LOG = LoggerFactory.getLogger(Ed25519JCA.class);

    @Test
    public void testEd25519WithJCA() throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        // Test case defined in https://tools.ietf.org/html/rfc8037
        var msg = "eyJhbGciOiJFZERTQSJ9.RXhhbXBsZSBvZiBFZDI1NTE5IHNpZ25pbmc".getBytes(StandardCharsets.UTF_8);
        var expectedSig = "hgyY0il_MGCjP0JzlnLWG1PPOt7-09PGcvMg3AIbQR6dWbhijcNR4ki4iylGjg5BhVsPt9g7sVvpAr_MuM0KAg";

        // Both formatted as 32bit raw key values (x and d)
        var privateKeyBytes = Base64.getUrlDecoder().decode("nWGxne_9WmC6hEr0kuwsxERJxWl7MmkZcDusAxyuf2A");
        var publicKeyBytes = Base64.getUrlDecoder().decode("11qYAYKxCrfVS_7TyWQHOg7hcvPapiMlrwIaaPcHURo");

        var keyFactory = KeyFactory.getInstance("Ed25519");

        // Wrap public key in ASN.1 format so we can use X509EncodedKeySpec to read it
        var pubKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), publicKeyBytes);
        var x509KeySpec = new X509EncodedKeySpec(pubKeyInfo.getEncoded());

        var jcaPublicKey = keyFactory.generatePublic(x509KeySpec);

        // Wrap private key in ASN.1 format so we can use
        var privKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), new DEROctetString(privateKeyBytes));
        var pkcs8KeySpec = new PKCS8EncodedKeySpec(privKeyInfo.getEncoded());

        var jcaPrivateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // Generate new signature
        var dsa = Signature.getInstance("EdDSA"); // Edwards digital signature algorithm
        dsa.initSign(jcaPrivateKey);
        dsa.update(msg, 0, msg.length);
        byte[] signature = dsa.sign();
        var actualSignature = Base64.getUrlEncoder().encodeToString(signature).replace("=", "");

        LOG.info("Expected signature: {}", expectedSig);
        LOG.info("Actual signature  : {}", actualSignature);

        assertEquals(expectedSig, actualSignature);
    }

}