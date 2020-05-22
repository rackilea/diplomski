import java.util.*;
import java.util.stream.*;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        list.add("baz");
        String result = list
            .stream()
            .map(s -> s.substring(0, 1))
            .collect(Collectors.joining());
        System.out.println(result); // fbb
    }
}