public class ThreadTest
{
    public static void main(String[] args)
    {
        for(int i = 0; i < 10; i++)
        {
            Thread thread = new Thread(new Runnable()
                {                   
                    public void run()
                    {
                        System.out.println("Hello from thread " + 
                            Thread.currentThread().getName());
                    }                   
                });
            thread.setName("MyThread-" + i);
            thread.start();
        }       
    }
}