import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.junit.Test;

public class EncodeToEscapes {

@Test
public void testEncoding() {
    final String src = "Hallo äöü"; // this has to be read with the right encoding
    final CharsetEncoder asciiEncoder = Charset.forName("US-ASCII").newEncoder();
    final StringBuilder result = new StringBuilder();
    for (final Character character : src.toCharArray()) {
        if (asciiEncoder.canEncode(character)) {
            result.append(character);
        } else {
            result.append("\\u");
            result.append(Integer.toHexString(0x10000 | character).substring(1).toUpperCase());
        }
    }
    System.out.println(result);
 }
}