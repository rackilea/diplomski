import java.io.IOException;
import sun.misc.BASE64Decoder;
public class PropertyPlaceholderConfigurer
  extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer {

  @Override
  protected String convertPropertyValue(final String originalValue) {
    String cryptString = "{base64}";
    if (originalValue.startsWith(cryptString)) {
      BASE64Decoder decoder = new BASE64Decoder();
      String decodedPassword = null;
      try {
        decodedPassword = new String(decoder.decodeBuffer(originalValue.substring(cryptString.length())));
      } catch (IOException e) {
        e.printStackTrace();
      }
      return decodedPassword;
    }
    return originalValue;
  }
}