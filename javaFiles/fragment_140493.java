import java.io.InputStream;
import java.io.OutputStream;

public final class Pipe implements Runnable {

    private final InputStream in;
    private final OutputStream out;

    public Pipe(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    public static void pipe(Process process) {
        pipe(process.getInputStream(), System.out);
        pipe(process.getErrorStream(), System.err);
        pipe(System.in, process.getOutputStream());
    }

    public static void pipe(InputStream in, OutputStream out) {
        final Thread thread = new Thread(new Pipe(in, out));
        thread.setDaemon(true);
        thread.start();
    }

    public void run() {
        try {
            int i = -1;

            byte[] buf = new byte[1024];

            while ((i = in.read(buf)) != -1) {
                out.write(buf, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}