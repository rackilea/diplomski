public class Class1Test {
    @Deprecated @Test public void test1() {
        System.out.println("" + this.getClass().getName() + " test1");
    }

    @Test public void test2() {
        System.out.println("" + this.getClass().getName() + " test2");
    }
}