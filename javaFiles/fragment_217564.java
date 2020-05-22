public class SimpleThreadPoolRMC {

    public SimpleThreadPoolRMC() {
       // if no initialization performed, leaving this empty is ok
    }

    // changed name to lowercase
    public void service() {
        // build a threadpool, and run it for a particular query 
        // ...
    }

    public static void main(String[] args) {
        SimpleThreadPoolRMC simple = new SimpleThreadPoolRMC();
        while (true) {
            // sleeps 5s
            simple.processCommand();
            simple.service();
        }
    }
}