import java.io.IOException;
import java.net.URLDecoder;

public class Dump {
  public static void main(String[] args) throws IOException {
    String reqMsg = 
         "test+%F0%9F%98%8E+1+%E2%99%A7+%E2%99%A2+%E2%99%A1+%E2%99%A4+%E3%80%8A";
    String decoded = URLDecoder.decode(reqMsg, "UTF-8");
    // UTF-16
    for (char ch : decoded.toCharArray()) {
      System.out.format("%04x ", (int) ch);
    }
    System.out.println();
    // UTF-8
    for (byte ch : decoded.getBytes("UTF-8")) {
      System.out.format("%02x ", 0xFF & ch);
    }
  }
}