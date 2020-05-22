import javax.crypto.Cipher;
import java.security.Security;

class Test {
  public static void main(String[] args) {
    Security.setProperty("crypto.policy", "unlimited");
    try {
      System.out.println("Hello World!");
      int maxKeyLen = Cipher.getMaxAllowedKeyLength("AES/CBC/PKCS5Padding");
      System.out.println(maxKeyLen);
    } catch (Exception e){
      System.out.println("Sad world :(");
    }
  }
}