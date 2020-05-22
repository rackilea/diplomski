import static org.junit.Assert.*;

import org.junit.Test;


public class XTest {

    @Test
    public void testQuickSortArray1() throws NumberFormatException, Exception {
        String numbers="12;57;65";
        String index="2";
        String result = new X().quickSortArray(numbers, index);
        assertEquals("57",result);
    }

    @Test
    public void testQuickSortArray2() throws NumberFormatException, Exception {
        String numbers="09;78;45;39;05";
        String index="3";
        String result = new X().quickSortArray(numbers, index);
        assertEquals("39",result);
    }

}