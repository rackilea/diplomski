import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] allFiles = { "output.txt", "test.txt" };

        // First method
        for (String file : allFiles) {
            System.out.println(Paths.get(file).toAbsolutePath());
        }

        // Second method (by using Stream)
        Arrays.stream(allFiles).forEach(file -> System.out.println(Paths.get(file).toAbsolutePath()));
    }
}