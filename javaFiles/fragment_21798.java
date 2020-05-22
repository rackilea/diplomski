public class Matrix
{
    // holds the matrix
    private int[][] matrix = new int[ 5 ][ 5 ];
    // fills up the matrix with zeroes   
    public void init()
    {
        for ( int i = 0; i < 5; ++i )
            Arrays.fill( matrix[i], 0 );
    }
    // prints the matrix out
    public void print()
    {
        for ( int i = 0; i < 5; ++i )
        {
            for ( int j = 0; j < 5; ++j )
                System.out.printf( "%3d", matrix[i][j] );
            System.out.println();
        }
    }
    // fills the matrix with the spiral
    public void generate()
    {
        // variables: co-ordinates, value, direction
        int x = 2, y = 2, val = 0, dir = 0;
        // in a 5×5 matrix we should put in 25 values...
        while ( val < 25 )
        {
            // put this value
            matrix[y][x] = ++val;
            // for debugging
            System.out.printf( "val=%d, x=%d, y=%d, dir=%d%n", val, x, y, dir );
            // calculate next value's position, and check if we must turn
            int turn = -1;
            switch ( dir )
            {
                case 0: // down, checking left
                    ++y;
                    if ( 25 != val ) // the last value would cause error
                        turn = matrix[y][x - 1];
                    break;
                case 1: // left, checking up
                    --x;
                    turn = matrix[y - 1][x];
                    break;
                case 2: // up, checking right
                    --y;
                    turn = matrix[y][x + 1];
                    break;
                case 3: // right, checking down
                    ++x;
                    turn = matrix[y + 1][x];
            }
            // next direction
            if ( 0 == turn )
                dir = ( dir + 1 ) & 3;
        }
    }
    // for testing
    public static void main( String[] args )
    {
        final Matrix m = new Matrix();
        m.init();
        m.generate();
        m.print();
    }
}