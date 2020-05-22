import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            Loader.instrumentTmcore(args);
        } catch (Exception e) {
            System.err.println("Ooops");
            e.printStackTrace();
        }
    }
}