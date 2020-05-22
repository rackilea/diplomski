import java.util.Base64;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException {
        byte[] data = java.util.Base64.getDecoder().decode(
        "e1xydGYxXGFuc2kNCkxvcmVtIGlwc3VtIGRvbG9yIHNpdCBhbWV0DQpccGFyIH0=");

        Path path = java.nio.file.Paths.get("/path/to/some/file");
        Files.write(path, data);
    }
}