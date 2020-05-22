public void test() {
    List<String> list = Arrays.asList("a", "b", "c", "d");
    String x = list.stream()
                   .filter("d"::equals)
                   .findAny()
                   .map(v -> "match the value")
                   .orElse(null);
}