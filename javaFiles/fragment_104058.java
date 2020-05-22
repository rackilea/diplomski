public class Main {

    public static void main(String[] args) {
        Thread myThread1 = new Main.MyThread();
        myThread1.run();
        Thread myThread2 = new Main.MyThread();
        myThread2.run();
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            for( int i = 0; i < 10; i ++ ) {
                System.out.println(i);
            }
        }
    }
}