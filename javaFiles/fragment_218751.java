import java.io.IOException;
import java.io.InputStream;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;


public class Main {
    public static void main(String[] args) throws Exception {
        new Main().test();
    }

    private Session sess;

    public void test() throws IOException, InterruptedException {
        Connection c  = new Connection("myserver", 22);
        c.connect();
        boolean OK = c.authenticateWithPassword("user", "pass");
        if (!OK) throw new IOException("Bad password");
        sess = c.openSession();
        sess.requestPTY("vt220");
        new Thread(stdoutLogger).start();
        sess.execCommand("/bin/bash");
        Thread.sleep(2000);
        sess.getStdin().write("echo Hello\n".getBytes());
        sess.getStdin().write("ls -l /tm\t".getBytes());
        Thread.sleep(4000);
        sess.close();
        c.close();
    }

    Runnable stdoutLogger = new Runnable() {
        public void run() {
            InputStream is = sess.getStdout();
            int b;
            try {
                while ( (b = is.read()) != -1) {
                    System.out.println("Read " + b + " - " + (char)b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
}