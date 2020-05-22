import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class readLineFromFile {


     public static void main(String[] args) throws IOException {

            String line = Files.readAllLines(Paths.get("E:\\text.txt")).get(7);
            System.out.println(line);  
        }

}