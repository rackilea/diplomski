import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class StringUtils {

  static CharsetEncoder asciiEncoder = 
      StandardCharsets.US_ASCII.newEncoder(); 

  public static boolean isPureAscii(String v) {
    return asciiEncoder.canEncode(v);
  }

  public static void main (String args[])
    throws Exception {

     String test = "Réal";
     System.out.println(test + " isPureAscii() : " + StringUtils.isPureAscii(test));
     test = "Real";
     System.out.println(test + " isPureAscii() : " + StringUtils.isPureAscii(test));
  }
}