import java.io.IOException;
import java.io.InputStream;

public class DataStreamUtil {
    public static String parseAsciiSockStream(InputStream in) throws IOException {
        StringBuilder builder = new StringBuilder();
        if (null != in) {
            byte[] b = new byte[BYTE_STREAM_MAX];
            System.out.println("Waiting for input");
            int length = in.read(b);
            System.out.println("Got input");
            for (int i = 0; i < length; i++) {
                builder.append((char) (int) b[i]);
            }
            in.close();
        }
        return builder.toString();
    }
}