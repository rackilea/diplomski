import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriterForEmptyDirectory {

    public static void main(String[] args) throws IOException {
        try (PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream("result")), true)) {

            String directoryPath = "a-path-to-analyse";
            Files.walk(Paths.get(directoryPath))
                 .filter(f -> {
                     try {
                         return Files.isDirectory(f) && Files.list(f)
                                                             .count() == 0;
                     } catch (IOException e) {
                         System.err.println("Error to handle for file " + f);
                         e.printStackTrace();
                         return false;
                     }
                 })
                 .forEach(f -> {
                     try {
                         writer.println(f);
                     } catch (Exception e) {
                         System.err.println("Error to handle for file " + f);
                         e.printStackTrace();
                     }
                 });
        }
    }
}