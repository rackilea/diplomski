public class MyServlet extends HttpServlet {
    private List<ServletManagedThread> threads = new ArrayList<ServletManagedThread>();     

     // lots of irrelevant stuff left out for brevity

    public void init() {
        ServletManagedThread t = new MyThread();
        threads.add(t);
        t.start();
    }

    public void destroy() {
        for(ServletManagedThread thread : threads) {
           thread.stopExecuting();
        }
    }
 }

 public abstract class ServletManagedThread extends Thread {

    private boolean keepGoing = true;

    protected abstract void doSomeStuff();
    protected abstract void probablySleepForABit();
    protected abstract void cleanup();

    public void stopExecuting() {
       keepRunning = false;
    }

    public void run() {
       while(keepGoing) {
            doSomeStuff();
            probablySleepForABit();
       }
       this.cleanup();
    }
}