import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);

        List<String> strings = new ArrayList(integers);
        // Bang!
        String x = strings.get(0);
    }
}