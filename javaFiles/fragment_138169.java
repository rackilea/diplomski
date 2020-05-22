public class SetTableTest{

    @Test
    public void test(){
        MyClass test = new MyClass();
        test.setTable(2, 2, 5);
        char[] row0 = {x, x} // This is whatever you would expect to be in row 0
        char[] row1 = {x, x} // This is whatever you would expect to be in row 1
        assertArrayEquals(row0, test.table[0]);
        assertArrayEquals(row1, test.table[1]);
    }
}