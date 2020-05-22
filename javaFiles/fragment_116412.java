public class Test {
    public static void main(String[] args) throws Exception {
        Runnable runnable = new Runnable() {
            @Override public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        // Give the new thread plenty of time to really start
        Thread.sleep(5000);
        System.out.println(thread.isAlive());
    }        
}