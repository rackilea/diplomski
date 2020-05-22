import com.sun.pdfview.PDFFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class PDFFileUtility {
private static final int READ_BLOCK = 8192;

public static PDFFile getPDFFile(InputStream in) throws IOException {
   ReadableByteChannel bc = Channels.newChannel(in);
   ByteBuffer bb = ByteBuffer.allocate(READ_BLOCK);
    while (bc.read(bb) != -1) {
        bb = resizeBuffer(bb); //get new buffer for read
    }
   return new PDFFile(bb);

}

 private static ByteBuffer resizeBuffer(ByteBuffer in) {
   ByteBuffer result = in;
   if (in.remaining() < READ_BLOCK) {
    result = ByteBuffer.allocate(in.capacity() * 2);
    in.flip();
    result.put(in);
   }
   return result;
}
}