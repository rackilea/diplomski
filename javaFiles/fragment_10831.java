import java.nio.*;
import java.nio.charset.*;

class Test {
   public static void main(String[] args) throws Exception {
       byte[] bytes = { 65, 66 }; // "AB" in ASCII
       ByteBuffer byteBuffer =
           ByteBuffer.wrap(bytes).asReadOnlyBuffer();
       CharBuffer charBuffer = StandardCharsets.US_ASCII.decode(byteBuffer);
       String text = charBuffer.toString();
       System.out.println(text); // AB
   }
}