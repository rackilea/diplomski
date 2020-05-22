public static void main(String[] args)
{
    int[][] matrix = new int[9][];
    double midPoint = (matrix.length-1)/2.0;
    for (int col = 0; col < matrix.length; col++)
    {
        int[] row = new int[matrix.length];
        double yy = col-midPoint;
        for (int x=0; x<row.length; x++)
        {
           double xx = x-midPoint;
           if (Math.sqrt(xx*xx+yy*yy)<=midPoint)
             row[x] = 1;
           System.out.print(row[x]);
        }
        matrix[col] = row;
        System.out.println();
    }

}