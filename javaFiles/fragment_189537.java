import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Work {
    public static void main(String[] args) throws IOException {
        Map<String, Long> dupes = Files.lines(Paths.get("/tmp/error.txt"))
                .collect(Collectors.groupingBy(Function.identity(), 
                     Collectors.counting()));

        // pretty print
        dupes.forEach((k, v)-> System.out.printf("(%d) times : %s ....%n", 
             v, k.substring(0,  Math.min(50, k.length()))));
    }
}