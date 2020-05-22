public static void run (Scanner input)
{
    int row = lengthRow(input);
    int column = lengthColumn(input);
    int result = maxValue(userMatrix(input, row, column));

    System.out.println("The largest value in the given Matrix is: " + result);
}