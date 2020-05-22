public static List<Integer> getIndexList(String s, char c) {
    return IntStream.range(0, s.length())
                    .filter(index -> s.charAt(index) == c)
                    .boxed()
                    .collect(Collectors.toList());
}