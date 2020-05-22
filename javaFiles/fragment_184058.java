public static List<Integer> createList(int[] array) {
    List<Integer> list = new ArrayList<Integer>(array.length);
    for (int i = 0; i < array.length; ++i) {
        list.add(array[i]);
    }
    return list;
}