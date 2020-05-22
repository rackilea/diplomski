import java.io.File;

public class Test {
    public static void main(String[] args) {
        File f = new File("\u2026");
        f.toPath();
    }
}