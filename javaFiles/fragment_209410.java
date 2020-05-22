import java.util.Map;
import java.util.Collections;
import java.net.URI;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JarPathTest {
    public static void main(String[] args)
    throws IOException {

        Path zip = Paths.get(args[0]);

        URI zipURI = URI.create("jar:" + zip.toUri());
        System.out.println(zipURI);

        Map<String, String> env = Collections.emptyMap();

        try (FileSystem fs = FileSystems.newFileSystem(zipURI, env)) {
            Path root = fs.getPath("/");
            System.out.println(root.toUri());
        }
    }
}