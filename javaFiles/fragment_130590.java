import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileEcho {
    void echo() throws IOException {
        try (PrintWriter pw = new PrintWriter("brabuhr.txt")) {
            Files.lines(Paths.get("words.txt"))
                .map(s -> new StringBuilder(s).reverse().toString())
                .forEach(pw::println);
        }
    }

    public static void main(String[] args) throws IOException {
        new FileEcho().echo();
    }
}