import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            new Server(3000).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}