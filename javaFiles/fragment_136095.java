public class ThreadTest {
public static void main(String args[]) throws InterruptedException
{
    new Thread(test).start();
    new Thread(test).start();
    new Thread(otherTest).start();
    new Thread(test).start();
    new Thread(otherTest).start();
    new Thread(test).start();
    new Thread(test).start();
    new Thread(test).start();
}

public static Runnable test = new Runnable() {
    @Override
    public void run()  {
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("test");
    }
};

public static Runnable otherTest = new Runnable() {
    @Override
    public void run(){
        try {
            Thread.sleep((long) (Math.random()*1000));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Othertest");
    }
};