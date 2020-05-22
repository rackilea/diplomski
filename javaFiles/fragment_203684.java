public static void main(String[] args) {
    List<String> strings = Arrays.asList("foo", "bar", "AaAa", "foobar",
            "BBBB", "AaBB", "FB", "Ea", "foo");
    Map<Integer, List<String>> stringsByHash = strings.stream()
            .collect(Collectors.groupingBy(String::hashCode));
    for (Entry<Integer, List<String>> entry : stringsByHash.entrySet()) {
        List<String> value = entry.getValue();
        int collisions = value.size() - 1;
        if (collisions > 0) {
            System.out.println(
                    "Got " + collisions + " collision(s) for strings "
                            + value + " (hash: " + entry.getKey() + ")");
        }
    }
}