import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

// Java Base64 Encoder / Java Base64 Decoder 

public class Base64Test {

  public static void main(String[] args) {
    BASE64Decoder decoder = new BASE64Decoder();
    BASE64Encoder encoder = new BASE64Encoder();
    try {
      String encodedBytes = encoder.encodeBuffer("(@@@@&&&&&)".getBytes());
      System.out.println("encodedBytes " + encodedBytes);
      byte[] decodedBytes = decoder.decodeBuffer(encodedBytes);
      System.out.println("decodedBytes " + new String(decodedBytes));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}