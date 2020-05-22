public class Test implements Runnable {
    public void run() {
        synchronized(this) { 
            // some work
        }
    }

    public static void main(String args[]) throws Exception {
        Test target = new Test();
        Thread t = new Thread(target);
        t.start();

        synchronized(target) {
            t.suspend();
        }
        System.out.println("Hi");
    }
}