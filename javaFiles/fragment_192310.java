import java.util.ArrayList;
import java.util.List;

public class Foo {
    public static void main(String... args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        list.stream().forEach(System.out::println);
    }
}