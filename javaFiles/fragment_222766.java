import java.nio.file.*;

String source = "C:\\test\\1.jpeg";
String newdir = "C:\\test123\\1.jpeg";

void setup() {
    try {
        Path temp = Files.move(Paths.get(source), Paths.get(newdir));
    } catch (IOException e) {
        print(e);
    }
}