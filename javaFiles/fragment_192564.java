public class ParallelTwoTest {

    @Test
    public void testOne() throws InterruptedException {
        System.out.println("ParallelTwoTest.testOne()");
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void testTwo() throws InterruptedException {
        System.out.println("ParallelTwoTest.testTwo()");
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void testThree() throws InterruptedException {
        System.out.println("ParallelTwoTest.testThree()");
        TimeUnit.SECONDS.sleep(5);
    }
}