public class TestClass
{
    private static int x = 0;
    private static final Object lock = new Object();  
    private static boolean canWrite = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    for(int i = 0; i < 10; i++)
                    {  
                        synchronized(lock)
                        {                            
                            if(!canWrite)                            
                                lock.wait();
                            System.out.println(x);
                            canWrite = false;
                            lock.notify();
                        }
                    }                    
                } 
                catch (InterruptedException e) {}
            }
        });        

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    for(int i = 0; i < 10; i++)
                    {                                                
                        synchronized(lock)
                        {                                                              
                            x++;
                            canWrite = true;
                            lock.notify();
                            lock.wait();
                        }
                    }                            
                } catch (InterruptedException ex) {}                                                                        
            }
        });
        t1.start();        
        t2.start();
    }
}