import java.util.function.Function;
import java.util.stream.Stream;

public class CombinedStreams
{
    public static void main(String[] args)
    {
        Stream<String> stream0 = Stream.of("line0", "line1");
        Stream<String> stream1 = Stream.of("line2", "line3");
        Stream<String> stream2 = Stream.of("line4", "line5");

        Stream<String> stream = Stream.of(stream0, stream1, stream2)
            .flatMap(Function.identity());

        stream.forEach(e -> System.out.println(e)); 
    }
}