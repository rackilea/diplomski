public class App {
    public static void main(String[] args) {
        App app = new App();
    }

    class Test implements Runnable {
        private boolean flag = false;

        public synchronized boolean getFlag() {
            return this.flag;
        }

        public synchronized void setFlag(boolean flag) {
            return this.flag = flag;
        }

        public void run() {
            while(true) {
                if (this.getFlag()) {   // Must use the getter here too!
                    System.out.println("True");
                }
            }
        }
    }

    public App() {
        Test t = new Test();
        Thread thread = new Thread(t);
        System.out.println("Starting thread");
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        t.setFlag(true);
        System.out.println("New flag value: " + t.getFlag());
}