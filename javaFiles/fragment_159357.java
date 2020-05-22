public class ExampleMonitor implements Runnable{
    // Condition for our barrier, note it is private
    private boolean t1Entered = false;

    public synchronized void synchronizedTimerMethod(){
        // Test the barrier (check if conditions hold)
        while (!t1Entered && !Thread.currentThread().getName().equals("t1")) { 
            try {
                // Did not pass barrier so wait and release lock
                wait();
            } catch (Exception e) {
                // Handle
            }
        }
        // Thread passed barrier and has acquired the lock and can do what it wants

        // Update condition so now anyone can enter/pass the barrier
        t1Entered = true;

        // If this method never terminates then no other thread can enter because lock is never released
        long enterTime = System.currentTimeMillis();
        while (true) {
            System.out.println(Thread.currentThread().getName());

            // Let's allow the method to return and thus release the lock after fixed amount of time
            // We can then see that threads other than t1 can now acquire the lock
            if (System.currentTimeMillis() - enterTime > 5000) {
                break;
            }
        }
        // Notify/wake up any waiting threads
        this.notifyAll();
    }

    public void run(){
        synchronizedTimerMethod();
        // Thread will now terminate
    }

    public static void main(String[] args) throws InterruptedException {
        ExampleMonitor ts1 = new ExampleMonitor();

        Thread t1=new Thread(ts1);
        t1.setName("t1");

        Thread t2=new Thread(ts1);
        t2.setName("t2");

        t2.start();
        // To illustrate how Monitors can be used to ensure 
        //  ordering despite the order threads start in
        Thread.sleep(2000);
        t1.start();
    }
}