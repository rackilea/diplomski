public class Test {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        };
        t.start();
        Thread.sleep(100); // make sure the other thread has started
        System.out.println(t.getState());
    }
}