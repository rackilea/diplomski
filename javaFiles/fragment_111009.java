public static Integer[] createRandomArray(int size) {
    Integer[] result = new Integer[size];
    Random randomGenerator = new Random();
    for(int i = 0; i < size; i++) {
        result[i] = randomGenerator.nextInt(size*100);
    }
    return result;
}

public static Integer[] createSortedArray(int size) {
    return createPartiallySortedArray(size, 0, size);
}

public static Integer[] createPartiallySortedArray(int size, int from, int to) {
    Integer[] result = createRandomArray(size);
    Arrays.sort(result, from, to);
    return result;
}

public static boolean isSorted(Integer[] original, Integer[] sorted) {
    Integer[] clonedOriginal = Arrays.copyOf(original, original.length);
    Arrays.sort(clonedOriginal);
    return Arrays.equals(clonedOriginal, sorted);
}