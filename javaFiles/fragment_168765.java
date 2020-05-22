import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Load {

    public static String loadOperation() throws IOException {
            return Files.lines(Paths.get("Notes.txt"))
                .collect(Collectors.joining("\n"));

    }
}