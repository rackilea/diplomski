public static Map<Integer, Integer> findDuplicates(int[] arr) {
    Map<Integer, Long> map = Arrays.stream(arr)
                                   .boxed()
                                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    Map<Integer, Integer> res = new TreeMap<>();

    map.entrySet().stream()
       .filter(entry -> entry.getValue() > 1)
       .forEach(entry -> res.put(entry.getKey(), entry.getValue().intValue() - 1));

    return res;
}