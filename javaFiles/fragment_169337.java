@Listeners(MyTestListener.class)
public class TestA {

    @Test
    @InternalTool(ids = "IT-1")
    public void test1() {
        System.out.println("test1");
        fail();
    }

    @Test
    @InternalTool(ids = {"IT-2", "IT-3", "IT-4"})
    public void test2() {
        System.out.println("test2");
    }
}