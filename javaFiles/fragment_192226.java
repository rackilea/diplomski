import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> result0 = Arrays.asList("/Videos/Templates/file.mp4", "/Videos/Templates/file2.mp4", "/Videos/Templates/file3.mp4");
        List<String> result2 = Arrays.asList("/Videos/Templates/file.mp4.sha256");

        result0.parallelStream()
            .filter(item0 -> result2.parallelStream()
                                .anyMatch(item2 -> item2.contains(item0)))
            .forEach(item0 -> System.out.println("sha matches files: " + item0));

    }
}