public class ParallelOneTest {

    @Test
    public void testOne() throws InterruptedException {
        System.out.println("ParallelOneTest.testOne()");
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void testTwo() throws InterruptedException {
        System.out.println("ParallelOneTest.testTwo()");
        TimeUnit.SECONDS.sleep(5);
    }

    @Test
    public void testThree() throws InterruptedException {
        System.out.println("ParallelOneTest.testThree()");
        TimeUnit.SECONDS.sleep(5);
    }
}