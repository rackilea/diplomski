import java.nio.file.*;

Path source = Paths.get("...");
Path newdir = Paths.get("...");

void setup() {
    try {
        Files.move(source, newdir);
    } catch (IOException e) {
        print(e);
    }
}