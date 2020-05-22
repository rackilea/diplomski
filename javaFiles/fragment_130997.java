// prepare arrays
List<int[][]> kidsL = new ArrayList<>();
int[][] square1 = new int[8][8];
int[][] square2 = new int[8][8];
int[][] square3 = new int[8][8];
for (int i = 0; i < 8; i++)
    for (int j = 0; j < 8; j++) {
        square1[i][j] = 1;
        square2[i][j] = 2;
        square3[i][j] = 3;
    }
kidsL.add(square1);
kidsL.add(square2);
kidsL.add(square3);

// find min
kidsL.stream()
        .mapToInt(a -> Arrays.stream(a).flatMapToInt(Arrays::stream).sum())
        .min()
        .ifPresent(System.err::println);

// find max
kidsL.stream()
        .mapToInt(a -> Arrays.stream(a).flatMapToInt(Arrays::stream).sum())
        .max()
        .ifPresent(System.err::println);