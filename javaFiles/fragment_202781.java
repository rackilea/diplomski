public static void main(String[] args)
{
    int a[][] = new int[2][2];

    for(int i=0; i<2; ++i)
    {
        for(int j=0; j<2; ++j)
        {
            a[i][j]=Integer.parseInt(args[2*i+j]);
        }
    }
}