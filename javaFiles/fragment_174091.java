@Listeners({MethodListener.class, ExtentListener.class})
public class SampleTest extends TestsBase {

    @Test(priority = 1)
    public void pass() {
        System.out.println("pass");
    }

    @Test(priority = 2)
    public void fail1() {
        System.out.println("fail1");
        Assert.fail();
    }

    @Test(priority = 3)
    public void fail2() {
        System.out.println("fail2");
        Assert.fail();
    }

    @Test(priority = 4)
    public void fail3() {
        System.out.println("fail3");
        Assert.fail();
    }

    @Test(priority = 5)
    public void fail4() {
        System.out.println("fail4");
        Assert.fail();
    }

    @Test(priority = 6, description = "pass;fail2")
    public void skip1() {
        System.out.println("skip1");
    }

    @Test(priority = 7, description = "pass;fail3")
    public void skip2() {
        System.out.println("skip2");
    }
}