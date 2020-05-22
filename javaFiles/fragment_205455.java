import java.io.*;

public class StreamFile {
    /** Stream through a file using a buffer. */
    final static int BUFSIZE = 1024; // Use a 1K buffer.

    public static void main(String[] args) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(args[0])));
        long totalBytes = 0;
        byte[] buf = new byte[BUFSIZE];
        while (bis.available() > 0) {
            totalBytes += bis.read(buf, 0, BUFSIZE); // Do something here with the data in buf.
            System.out.println(totalBytes); // Show progress.
        }
        System.out.println("Read " + totalBytes + " bytes");
        bis.close();
    }
}