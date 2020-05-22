public static int arraySum(int[][] array){
    int total = 0;

    for (int row = 0; row < array.length; row++)
    {

        total += array[row][row];
    }

    return total;
}