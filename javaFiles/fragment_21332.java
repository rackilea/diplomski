import java.util.stream.*;
import java.util.Random;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class RandomListGeneration {
    public static void main(String args[]) {
        Random rnd = new Random();
        int n = 42;
        List<Integer> result = Stream
            .generate(rnd::nextInt)
            .limit(n)
            .collect(toList());
        System.out.println(result);
    }
}