import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CompletableFuture;

public class S3SyncProcess {

    public static void main(String[] args) throws IOException, InterruptedException {
        // sync dir
        Process process = Runtime.getRuntime().exec(
            new String[] {"aws", "s3", "sync", "dir", "s3://my.bucket"}
        );

        CompletableFuture.runAsync(() -> pipe(process.getInputStream(), System.out));
        CompletableFuture.runAsync(() -> pipe(process.getErrorStream(), System.err));

        // Wait for exit
        System.exit(process.waitFor());
    }

    private static void pipe(InputStream in, OutputStream out) {
        int c;
        try {
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            // ignore
        }
    }

}