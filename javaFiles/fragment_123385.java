public class AspectTest {
    public static int add(int i) {
        return i+100;
    }

    @Test
    public void test() throws Exception {
        int j = add(10);
        assertEquals(110, j);
        add(20);
    }
}