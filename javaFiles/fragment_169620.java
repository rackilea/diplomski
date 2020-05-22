public static Map<Integer, Integer> findDuplicates(int[] arr) {
    Set<Integer> values = new HashSet<>();
    Map<Integer, Integer> map = new TreeMap<>();

    for (int val : arr)
        if (!values.add(val))
            map.put(val, map.getOrDefault(val, 0) + 1);

    return map;
}