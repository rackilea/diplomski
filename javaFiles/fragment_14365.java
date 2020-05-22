import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main_copie {

    public static void main(String[] args) {


        Path source = Paths.get("data/image1.png");
        Path destination = Paths.get("MyFolder/image1_copied.png");

        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);   
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}