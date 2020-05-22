System.out.println(
    java.util.Arrays.toString(
        new int[][] {
            { 1 },
            { 2, 3 },
        }
    )
); // prints "[[I@187aeca, [I@e48e1b]"

System.out.println(
    java.util.Arrays.deepToString(
        new int[][] {
            { 1 },
            { 2, 3 },
        }
    )
); // prints "[[1], [2, 3]]"