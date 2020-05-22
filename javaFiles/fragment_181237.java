import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

import org.spongycastle.util.io.pem.PemObject;
import org.spongycastle.util.io.pem.PemReader;

public class VerifySignature {
    public static void main(final String[] args) throws Exception {
        try (PemReader reader = publicKeyReader(); InputStream data = data(); InputStream signatureData = signature()) {
            final PemObject publicKeyPem = reader.readPemObject();
            final byte[] publicKeyBytes = publicKeyPem.getContent();
            final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            final X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            final RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(publicKeySpec);

            final Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);

            final byte[] buffy = new byte[16 * 1024];
            int read = -1;
            while ((read = data.read(buffy)) != -1) {
                signature.update(buffy, 0, read);
            }

            final byte[] signatureBytes = new byte[publicKey.getModulus().bitLength() / 8];
            signatureData.read(signatureBytes);

            System.out.println(signature.verify(signatureBytes));
        }
    }

    private static InputStream data() throws FileNotFoundException {
        return new FileInputStream("someHTMLDoc.html");
    }

    private static PemReader publicKeyReader() throws FileNotFoundException {
        return new PemReader(new InputStreamReader(new FileInputStream("publicKey.pem")));
    }

    private static InputStream signature() throws FileNotFoundException {
        return new FileInputStream("signature.bin");
    }
}