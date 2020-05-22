import java.util.Arrays;

public class Grid
{

    public char[][] layout = new char[10][10];

    public Grid()
    {
        for ( char[] row : layout )
        {
            Arrays.fill( row, '-' );
        }

    }
}