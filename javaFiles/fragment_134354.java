public class OuterClass {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new OuterClass().new InnerThread());
        t.start();
        t.join();
    }

    public void method(String param1, String param2) {
        System.out.println("Test method ("+param1+","+param2+")");
    }

    public class InnerThread extends Thread {

        public void run() {
            System.out.println("Test thread");
            method("A", "B");
        }
    }
}