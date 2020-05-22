import java.io.IOException;
import java.io.InputStream;

public class Test {

    public static void main(String[] args) {
        String cmd = "/Applications/TextEdit.app";
        //String cmd = "/Applications/Sublime Text 2.app";
        String fileToEdit = "/Users/.../Documents/Test.txt";

        System.out.println("Cmd = " + cmd);
        ProcessBuilder pb = new ProcessBuilder("open", "-a", cmd, fileToEdit);
        pb.redirectErrorStream(true);
        try {
            Process p = pb.start();
            Thread t = new Thread(new InputStreamConsumer(p.getInputStream()));
            t.start();
            int exitCode = p.waitFor();
            t.join();
            System.out.println("Exited with " + exitCode);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static class InputStreamConsumer implements Runnable {

        private InputStream is;

        public InputStreamConsumer(InputStream is) {
            this.is = is;
        }

        @Override
        public void run() {
            int read = -1;
            try {
                while ((read = is.read()) != -1) {
                    System.out.print((char)read);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}