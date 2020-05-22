import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtils {

    private static String ENCRYPTION_KEY = "1234512345123456";

    public static void main(String[] args) {
        String encyString = new EncryptionUtils().encrypted("HJUSER153");
        System.out.println("Encrypted String:" + encyString);
     }

    public String encrypted(String strToEncrypt) {
         try {
            IvParameterSpec ivspec = new IvParameterSpec(ENCRYPTION_KEY.getBytes());

            SecretKeySpec keyspec = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
            //encrypted = cipher.doFinal(text.getBytes());
        } catch (Exception e) {
            System.out.println("\nException while encrypting " + strToEncrypt + " \nerror: " + e.getMessage());
        }
        return null;
    }

}