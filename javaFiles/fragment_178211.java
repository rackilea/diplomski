import java.util.stream.Stream;

class Test {
    public static void main(String[] args) {
        Stream.of(1, 2, 3).flatMap(i ->
                Stream.of(i, i * 2).onClose(() ->
                        System.out.println("Closed!")
                )
        ).forEach(System.out::println);
    }
}

1
2
Closed!
2
4
Closed!
3
6
Closed!