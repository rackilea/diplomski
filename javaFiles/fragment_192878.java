public class Foo {

    public static void main(String[] args) {
        String x = "new";

        Stream<Character> characters = x.chars().mapToObj(i -> (char) i);
        characters.forEach(System.out::println);
    }
}