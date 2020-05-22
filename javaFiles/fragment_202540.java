int[] a = {1, 2, 3, 4, 5, 6};

// logicalarray=[0 1 0 0 0 1];
// index is zero-based in Java
int[] result = IntStream.of(1, 5)
        .map(i -> a[i])
        .toArray();

System.out.println("result = " + Arrays.toString(result));