int[] array1 = {1, 2, 65, 4, 8, 5, 7, 18, 6, 0};
    int[] array2 = {0, 2, 11, 12, 5, 6, 8};
    int[] merged = IntStream.concat(IntStream.of(array1), IntStream.of(array2))
        .distinct()
        .sorted()
        .toArray();