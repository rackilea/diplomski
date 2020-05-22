public static <E> void insertAndProcess(List<E> list) {

    // Iterate through the list for some range of values i to j
    E value = list.get(i);

    // Process the element and put it back at some index
    putHelper(list, i+1, value);

    // Repeat the same for few more elements
}