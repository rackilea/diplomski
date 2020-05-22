import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyPair;
import java.security.Security;
import java.security.Signature;
import java.util.Arrays;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMReader;
import org.bouncycastle.openssl.PasswordFinder;
import org.bouncycastle.util.encoders.Hex;

public class SignatureExample {

    public static void main(String [] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        String message = "hello world";
        File privateKey = new File("private.pem");
        KeyPair keyPair = readKeyPair(privateKey, "password".toCharArray());

        Signature signature = Signature.getInstance("SHA256WithRSAEncryption");
        signature.initSign(keyPair.getPrivate());
        signature.update(message.getBytes());
        byte [] signatureBytes = signature.sign();
        System.out.println(new String(Hex.encode(signatureBytes)));

        Signature verifier = Signature.getInstance("SHA256WithRSAEncryption");
        verifier.initVerify(keyPair.getPublic());
        verifier.update(message.getBytes());
        if (verifier.verify(signatureBytes)) {
            System.out.println("Signature is valid");
        } else {
            System.out.println("Signature is invalid");
        }
    }

    private static KeyPair readKeyPair(File privateKey, char [] keyPassword) throws IOException {
        FileReader fileReader = new FileReader(privateKey);
        PEMReader r = new PEMReader(fileReader, new DefaultPasswordFinder(keyPassword));
        try {
            return (KeyPair) r.readObject();
        } catch (IOException ex) {
            throw new IOException("The private key could not be decrypted", ex);
        } finally {
            r.close();
            fileReader.close();
        }
    }

    private static class DefaultPasswordFinder implements PasswordFinder {

        private final char [] password;

        private DefaultPasswordFinder(char [] password) {
            this.password = password;
        }

        @Override
        public char[] getPassword() {
            return Arrays.copyOf(password, password.length);
        }
    } 
}