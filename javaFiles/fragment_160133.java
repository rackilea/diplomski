public static void diagonalSums ()
{
    int[][] arr = {{1, 2, 3},
                   {5, 6, 7},
                   {8, 2, 3}};
    System.out.println("first " + IntStream.range(0,arr.length).map(i -> arr[i][i]).sum());
    System.out.println("second " + IntStream.range(0,arr.length).map(i -> arr[i][arr.length-1-i]).sum());
}