import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("test.xy", "abctest.xy", "testaxy", "testy");
        for (String s : list) {
            if (s.contains("test.xy"))
                System.out.println(s);
        }

        // Display using Stream
        System.out.println("\nFilter and display using Stream:");
        list.stream().filter(s -> s.contains("test.xy")).forEach(System.out::println);
    }
}