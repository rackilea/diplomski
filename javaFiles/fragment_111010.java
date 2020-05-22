public static void main(String[] args) {
    List<Integer[]> arrays = new ArrayList<Integer[]>();
    int size = 100;
    arrays.add(createRandomArray(size));
    arrays.add(createPartiallySortedArray(size, 0, size/2));
    arrays.add(createSortedArray(size));

    List<Integer[]> result = doBubbleSort(arrays);  // <- implement that method
    for (int i = 0; i < arrays.size(); i++)
        System.out.println(isSorted(arrays.get(i), result.get(i)));
}