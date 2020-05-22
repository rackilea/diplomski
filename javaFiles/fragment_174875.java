import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Testing {
    public static void main(String[] args) throws IOException {
        Files.writeString(Paths.get("D://output.txt"), "some text to write", StandardOpenOption.CREATE);
    }
}