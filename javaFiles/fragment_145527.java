public void test() {
    int[] listOfNumbers = {5, 4, 13, 7, 7, 8, 9, 10, 5, 92, 11, 3, 4, 2, 1};
    // Works fine but is really designed for ints instead of int[]s.
    System.out.println(IntStream.of(listOfNumbers).sum());
    // Expected use.
    System.out.println(IntStream.of(5, 4, 13, 7, 7, 8, 9, 10, 5, 92, 11, 3, 4, 2, 1).sum());
    // Probably a better approach for an int[].
    System.out.println(Arrays.stream(listOfNumbers).sum());
}