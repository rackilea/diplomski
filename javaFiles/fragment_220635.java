public class RunnableTest implements Runnable{

public void run()
{
    while(true)
    {   
        System.out.println("Tick!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }       
}

}