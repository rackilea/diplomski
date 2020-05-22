int a = 4;               // Number of outer array elements
int b = 2;               // Number of inner array elements

int[][] board = IntStream
    .range(0, a)                                               // iterate 0..3
    .mapToObj(i -> IntStream.range(0, b)                       // for each iteratoe 0..1
                            .map(j -> 1 + (i + (a + 1) * j))   // calculate the value
                            .toArray())                        // compose the inner array
    .toArray(int[][]::new);                                    // compose the outer array