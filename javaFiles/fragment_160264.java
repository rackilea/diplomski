import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunBatch {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder(
                        "cmd", "/c", "listme.bat"
        );
        pb.directory(new File("C:/Program Files"));
        pb.redirectError();
        try {
            Process process = pb.start();
            InputStreamConsumer.consume(process.getInputStream());
            System.out.println("Exited with " + process.waitFor());
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static class InputStreamConsumer implements Runnable {

        private InputStream is;

        public InputStreamConsumer(InputStream is) {
            this.is = is;
        }

        public static void consume(InputStream inputStream) {
            new Thread(new InputStreamConsumer(inputStream)).start();
        }

        @Override
        public void run() {
            int in = -1;
            try {
                while ((in = is.read()) != -1) {
                    System.out.print((char) in);
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

    }

}