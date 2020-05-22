public static void main(String[] args) {
    Stream<String> strings = Arrays.asList("a", "b", "c", "e", "f", "d").stream();
    Stream<Integer> ints = Arrays.asList(1, 2, 3, 6, 5, 4).stream();
    Stream<String> results = join(strings, ints, 
            Function.identity(),
            str    -> Integer.parseInt(str, 16) - 9, 
            (o, i) -> "Outer: " + o + ", Inner: " + i);
    results.forEach(r -> System.out.println(r));
}