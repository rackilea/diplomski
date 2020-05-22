import java.io.IOException;

public class FileBlobTest {

    public static void main(String[] args) {
        FileBlobFactory factory = new FileBlobFactory();
        for (int i = 0; i < 10; i++) {
            try {
                factory.create();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        while(true) {
            try {
                Thread.sleep(5000);
                System.gc(); System.gc(); System.gc();
            } catch (InterruptedException exc) {
                exc.printStackTrace();
                System.exit(1);
            }
        }
    }
}