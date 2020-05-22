public class ExampleCountDownLatch
{
    public void doSomething () throws InterruptedException
    {
        final CountDownLatch latch = new CountDownLatch(1);

        Thread thread = new Thread()
        {
            public void run ()
            {
                System.out.println("do something");
                latch.countDown();
            }
        };

        System.out.println("waiting for execution of method in your example class");
        thread.start();
        // wait for reasonable time otherwise kill off the process cause it took
        // too long.
        latch.await(3000, TimeUnit.MILLISECONDS);

        // now I can do something from your example 2
        System.out.println("now i can execute from example 2 do something else");
    }
}