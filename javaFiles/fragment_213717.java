import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class TestFC {
        public static void main(String a[]) throws IOException{
                File f = new File("in.txt");
                try(RandomAccessFile in = new RandomAccessFile(f, "rws"); FileChannel fc = in.getChannel();) {
                        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, f.length());

                        Charset charset = Charset.forName("US-ASCII");
                        CharsetDecoder decoder = charset.newDecoder();
                        CharBuffer cb = decoder.decode(mbb);

                        for(int i=0; i<cb.limit();i++) {
                                System.out.print(cb.get(i));
                        }
                }
        }
}