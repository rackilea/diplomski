public static boolean hasSameElements(int[] a, int[] b) {
    if (a.length != b.length) {
        return false;
    }

    Map<Integer, Long> popCount =
            Arrays.stream(a)
                  .mapToObj(Integer::valueOf)
                  .collect(Collectors.groupingBy(Function.identity(), 
                           Collectors.counting()));

    for (int elem : b) {
        Long count = popCount.get(elem);
        if (count == null) {
            return false;
        }
        count--;
        if (count == 0L) {
            popCount.remove(elem);
        } else {
            popCount.put(elem, count);
        }
    }

    return popCount.isEmpty();
}