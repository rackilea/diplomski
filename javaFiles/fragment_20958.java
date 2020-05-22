public class MyThread extends Thread
{

    private static Object lock = new Object();

...
            synchronized (lock)
            {
                Thread.sleep(1000);
                System.out.println(number + "\t" + person.getSurname());
                Thread.sleep(1000);
                System.out.println(number + "\t" + person.toString());
            }
...