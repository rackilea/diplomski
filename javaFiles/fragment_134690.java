public double[,,] ZeroMatrix(int rows, int cols, int etc)
{
    double[,,] m = new double[rows, cols, etc];

    for (int i = 0; i < rows; i++)
        for (int j = 0; j < cols; j++)
            for(int k = 0 ; k < etc ; k++)
                m[i , j , k] = 0;

    return m;
}