static <T extends Comparable<T>> List<Integer> getSortOrder(List<T> list) {
    // Ints in increasing order from 0. One for each entry in the list.
    List<Integer> order = IntStream.rangeClosed(0, list.size() - 1).boxed().collect(Collectors.toList());
    Collections.sort(order, (o1, o2) -> {
        // Comparing the contents of the list at the position of the integer.
        return list.get(o1).compareTo(list.get(o2));
    });
    return order;
}

// Array form.
static <T extends Comparable<T>> List<Integer> getSortOrder(T[] list) {
    return getSortOrder(Arrays.asList(list));
}

static <T> List<T> reorder(List<T> list, List<Integer> order) {
    return order.stream().map(i -> list.get(i)).collect(Collectors.toList());
}

// Array form.
static <T> T[] reorder(T[] list, List<Integer> order) {
    return reorder(Arrays.asList(list), order).toArray(list);
}


public void test(String[] args) {
    Integer arr[] = {2,3,2,4,5,12,2,3,3,3,12};
    Integer val[] = {3,4,3,1,1,2,2,3,4,4,4,2};
    List<Integer> sortOrder = getSortOrder(val);
    Integer[] reordered = reorder(arr, sortOrder);
    System.out.println(Arrays.toString(reordered));
}