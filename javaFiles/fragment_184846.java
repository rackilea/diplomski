synchronized (ThreadSyncDemo.class)
{
   //lock at class level
}

{
public class ThreadSyncDemo extends Thread{
    String name;

    @Override
    public void run() {     
        wish();
    }

    public synchronized void wish(){
        synchronized(ThreadSyncDemo.class) {
            for(int i=0;i<5;i++){
                System.out.println("Good morning");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.print(name);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        ThreadSyncDemo th = new ThreadSyncDemo();
        th.name="Test";
        th.start();
        ThreadSyncDemo th1 = new ThreadSyncDemo();
        th1.name="Test1";
        th1.start();    
    }
}