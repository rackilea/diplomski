public static void main(String[] args)
{
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of rows");
    int r = sc.nextInt();
    System.out.println("Enter number of columns");
    int c = sc.nextInt();
    System.out.println("Enter values");
    int[][] matrix = new int[r][c];

    for (int i = 0; i < r; i++)
    {
        float rowSum = 0f;
        for (int j = 0; j < c; j++)
        {
            matrix[i][j] = sc.nextInt();
            rowSum += matrix[i][j];
        }
        System.out.println("Average of row " + i + " " + rowSum / c);
    }
    for (int i = 0; i < c; i++)
    {
        float columnSum = 0f;
        for (int j = 0; j < r; j++)
        {
            columnSum += matrix[j][i];
        }
        System.out.println("Average of column " + i + " " + columnSum / r);
    }
    sc.close();
}