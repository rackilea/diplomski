public class SimpleThreadPoolRMC {

    public SimpleThreadPoolRMC() {
        // sleeps 5s
        processCommand();
        // call service method
        Service();
    }

    public void Service() {
        // build a threadpool, and run it for a particular query 
        // ...

        // gratitious recursion!
        new SimpleThreadPoolRMC();
    }

    public static void main(String[] args) {
        new SimpleThreadPoolRMC();  
    }
}