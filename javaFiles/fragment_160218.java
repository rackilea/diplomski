import java.nio.file.Files;
import java.nio.file.Paths;
import javax.crypto.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String fileName = "encryptedtext.txt";
        String fileName2 = "decryptedtext.txt";

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);

        SecretKey secKey = keyGen.generateKey();

        Cipher aesCipher = Cipher.getInstance("AES");


        byte[] byteText = "Your Plain Text Here".getBytes();

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(byteText);
        Files.write(Paths.get(fileName), byteCipherText);


        byte[] cipherText = Files.readAllBytes(Paths.get(fileName));

        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
        byte[] bytePlainText = aesCipher.doFinal(cipherText);
        Files.write(Paths.get(fileName2), bytePlainText);
    }
}