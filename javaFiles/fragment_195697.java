public static boolean hasSameElements(int[] a, int[] b) {
    return countElements(a).equals(countElements(b);)
}

private static Map<Integer, Long> countElements(int[] arr) {
    return Arrays.stream(arr)
                 .boxed()
                 .collect(Collectors.groupingBy(Function.identity(), 
                          Collectors.counting()));
}