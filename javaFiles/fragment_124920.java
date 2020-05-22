import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempStackTest {
    public Path getTempFilePath() {
        Path path = null;
        try {
            path = Files.createTempFile("XYZ", "Directory");
            path.toFile().delete();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}