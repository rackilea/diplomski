public Matrix(double[][] array) //Create matrix values
{
    Random rand = new Random();

    for(int i = 0; i < array.length; i++)
    {
        for(int j = 0; j < array[i].length; j++)
        {
            array[i][j] = rand.nextInt(10);
            System.out.print(array[i][j] + " | ");
        }
        System.out.println();
    }