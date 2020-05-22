public static int[][] to2d(List<? extends List<Integer>> matrix) {
    return matrix.stream()
                  // convert each List<Integer> to an int[]
                  .map(a -> a.stream().mapToInt(i -> i).toArray())
                  // convert the int[]s to an int[][]
                  .toArray(int[][]::new);
}