public static void main(String[] args) {
    List<String> list = Arrays.asList("\"AB\", \"XY\", 10", "\"CD\", \"XY\", 15", "\"CD\", \"XY\", 12", "\"AB\", \"XY\", 19");

    Map<String, Integer> map =
        list.stream()
            .collect(Collectors.groupingBy(
                s -> s.substring(0, s.lastIndexOf(',')),
                Collectors.summingInt(s -> Integer.parseInt(s.substring(s.lastIndexOf(',') + 2)))
            ));
    List<String> result =
        map.entrySet()
           .stream()
           .map(e -> e.getKey() + ", " + e.getValue())
           .collect(Collectors.toList());

    System.out.println(result);
}