import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ImageServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000);
            Socket accept = server.accept();
            InputStream inputStream = accept.getInputStream();
            BufferedInputStream stream = new BufferedInputStream(inputStream);
            int length = readInt(inputStream);
            byte[] buf = new byte[length];
            for (int read = 0; read < length; ) {
                read += stream.read(buf, read, buf.length - read);
            }
            stream.close();

            FileOutputStream fos = new FileOutputStream("image.png");
            fos.write(buf, 0, buf.length);
            fos.flush();
            fos.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int readInt(InputStream inputStream) throws IOException {
        byte[] buf = new byte[4];
        for (int read = 0; read < 4; ) {
            read += inputStream.read(buf, 0, 4);
        }
        return toInt(buf);
    }

    public static int toInt(byte[] b) {
        return (b[0] << 24)
                + ((b[1] & 0xFF) << 16)
                + ((b[2] & 0xFF) << 8)
                + (b[3] & 0xFF);
    }
}