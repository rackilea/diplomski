public class TestThread 
{
    public static void main (String [] args) 
    {
        Thread t = new MyThreads() 
        {
            public void run() 
            {
                System.out.println(" foo");
            }
        };
        t.start();

        Thread t1 = new MyThreads() 
        {
            public void run() 
            {
                System.out.println(" this time it is somethidn else");
            }
        };
        t1.start();

        System.out.println("out of run");
    }
}