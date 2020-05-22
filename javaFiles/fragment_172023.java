public static double[] columnSums(double[][] q)
{
    double[][] array = q;

    double[] columns = new double[5];

    for (int a = 0; a < array[0].length; a++)
    {
        for (int b = 0; b < array.length; b++)
        {   
            columns[a] += array[b][a];
        }
    }
    return columns;
}