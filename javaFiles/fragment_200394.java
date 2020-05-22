import java.io.IOException;
import java.io.InputStream;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("/Applications/Xcode.app/Contents/MacOS/Xcode");
        pb.redirectErrorStream(true);
        Process p = pb.start();
        // Yes, I'm a bad developer, but I just want to demonstrate
        // the use of the PID method :/
        new Thread(new Consumer(p.getInputStream())).start();
        System.out.println("PID = " + p.pid());
        p.waitFor();
        System.out.println("Exit with " + p.exitValue());
    }

    public static class Consumer implements Runnable {
        private InputStream is;

        public Consumer(InputStream is) {
            this.is = is;
        }

        @Override
        public void run() {
            try {
                int value = -1;
                while ((value = is.read()) != -1) {
                    // I'm ignoring it for brevity
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}