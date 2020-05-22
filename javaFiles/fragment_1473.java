import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
        String path = "/a/b/c/d";
        Path p = Paths.get(path);
        int num = p.getNameCount();
        System.out.println(num);  // prints 4
    }
}