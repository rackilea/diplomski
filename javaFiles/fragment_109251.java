class SampleTask implements Runnable
{
    public void run()
    {
        System.out.println("Calling someStaticMethod");
        Test.someStaticMethod();
        System.out.println("someStaticMethod returned");
    }
}

public class Test
{
    static
    {
        System.out.println("Starting new thread...");
        new Thread(new SampleTask()).start();
        System.out.println("Thread started. Sleeping");
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Interrupted!");
        }
        System.out.println("Finished sleeping");          
    }

    public static void someStaticMethod()
    {
        System.out.println("In someStaticMethod");
    }

    public static void main(String[] args)
    {
        System.out.println("In main. Sleeping again.");
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Interrupted!");
        }
    }
}