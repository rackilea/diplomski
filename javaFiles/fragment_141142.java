import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MagicSquareTest
{
    @Test
    public void testMagicSquare1()
    {
        int[][] matrix = { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } };
        MagicSquare square = new MagicSquare(matrix);
        // this is a valid magic square
        assertTrue(square.isValid());
    }

    @Test
    public void testMagicSquare2()
    {
        int[][] matrix = { { 2, 7, 5 }, { 9, 5, 1 }, { 4, 3, 8 } };
        MagicSquare square = new MagicSquare(matrix);
        // this is an invalid magic square
        assertFalse(square.isValid());
    }
}