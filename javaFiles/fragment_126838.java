class Totalizer implements Runnable
{
    int total = 0;
    boolean calculationComplete; // Condition to check in wait()
    public void run() {
        for(int i = 0; i < 100; i++) {
            total += i;     
        }
        synchronized (this) {
            // Indicate condition for wait() is now true
            calculationComplete = true;
            notifyAll();
        }   
    }   
}
class Tester extends Thread
{
    Totalizer t;
    public Tester(Totalizer tot){t = tot;}
    public void run(){
        synchronized(t) {
            System.out.println("Waiting for calculation...");
            // Loop, terminate when condition is true
            while (!t.calculationComplete) {
                try {
                    t.wait();
                } catch (InterruptedException e) {}
            }

            System.out.println(t.total);
        }
    }