public class TestShiro  implements Runnable {

private static final DefaultPasswordService defaultPasswordService = new DefaultPasswordService();

protected void exec() {
/*  calling 
 * defaultPasswordService.setHashFormat(   new Shiro1CryptFormat() ); 
 * will lead to a data race
 */
    defaultPasswordService.encryptPassword( Thread.currentThread().getName());

}

private AtomicInteger threadCount = new AtomicInteger();

public void test() throws Exception
{
    for(int i = 0; i < 8 ;i++)
    {
        Thread thread = new Thread(this, "First Test Thread " + i);
        this.threadCount.incrementAndGet();
        thread.start();
    }


    while( this.threadCount.get() > 0 )
    {
        Thread.sleep(1000);
    }


    Thread.sleep(10 * 1000);
}


public void run()
{
    exec();
    threadCount.decrementAndGet();

}

public static void main(String[] args) throws Exception
{
     (new TestShiro()).test();
}
}