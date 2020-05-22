import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.Assert.assertEquals;

public class BouncyCastleTest {

    private static final Logger LOG = LoggerFactory.getLogger(BouncyCastleTest.class);

    @Test
    public void testBouncyCastle() throws CryptoException  {
        // Test case defined in https://tools.ietf.org/html/rfc8037
        var msg = "eyJhbGciOiJFZERTQSJ9.RXhhbXBsZSBvZiBFZDI1NTE5IHNpZ25pbmc".getBytes(StandardCharsets.UTF_8);
        var expectedSig = "hgyY0il_MGCjP0JzlnLWG1PPOt7-09PGcvMg3AIbQR6dWbhijcNR4ki4iylGjg5BhVsPt9g7sVvpAr_MuM0KAg";

        var privateKeyBytes = Base64.getUrlDecoder().decode("nWGxne_9WmC6hEr0kuwsxERJxWl7MmkZcDusAxyuf2A");
        var publicKeyBytes = Base64.getUrlDecoder().decode("11qYAYKxCrfVS_7TyWQHOg7hcvPapiMlrwIaaPcHURo");

        var privateKey = new Ed25519PrivateKeyParameters(privateKeyBytes, 0);
        var publicKey = new Ed25519PublicKeyParameters(publicKeyBytes, 0);

        // Generate new signature
        Signer signer = new Ed25519Signer();
        signer.init(true, privateKey);
        signer.update(msg, 0, msg.length);
        byte[] signature = signer.generateSignature();
        var actualSignature = Base64.getUrlEncoder().encodeToString(signature).replace("=", "");

        LOG.info("Expected signature: {}", expectedSig);
        LOG.info("Actual signature  : {}", actualSignature);

        assertEquals(expectedSig, actualSignature);
    }
}