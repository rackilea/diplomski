static void printMat(byte[][] mat) 
// just a utility function to print a matrix
{ 
    for(byte[] row : mat)
    {
        System.out.println(Arrays.toString(row));
    }
}

private static byte[][] stretch(byte[][] bytes, int rfactor, int cfactor)
// stretch the matrix in 'bytes'
//stretch the rows by 'rfactor' and the columns by 'cfactor'
{ 
    // create an empty matrix:
    int rows = bytes.length*rfactor; // rows in the new matrix
    int cols = bytes[0].length*cfactor; // columns in the new matrix
    byte[][] out = new byte[rows][cols]; // our new, stretched matrix

    // loop through the rows and columns of the *new* matrix:
    for(int r = 0; r < rows; r++)
    {
        for(int c = 0; c < cols; c++)
        {
            // Divide the row and column indices by the 
            // appropriate factors to find the correct value
            // in the original matrix.
            // Integer division just drops any remainder,
            // which is what we want.
            out[r][c] = bytes[r/rfactor][c/cfactor];
        }
    }
    return out;
}

public static void main(String[] args) throws Exception 
{
    // your example:
    byte[][] byteArray =
        {{1, 0},
         {0, 1}};
    byte[][] newarray = stretch(byteArray, 10, 10);
    printMat(newarray);

    System.out.println();

    // can stretch any matrix by any dimensions:
    byte[][] byteArray2 =
        {{1, 2, 3},
         {4, 5, 6}};
    byte[][] newarray2 = stretch(byteArray2, 3, 2);
    printMat(newarray2);

}