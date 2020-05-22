import java.util.concurrent.Semaphore;

class A extends Thread {

        private int i;
        final static Semaphore semaphore = new Semaphore(1, true);

        public A(int x) {
            i = x;
        }

        public void run() {
            try {

                /*thread stops here until it gets permit to go on*/
                semaphore.acquire();
                System.out.println(i);
            /*exception must be caught or thrown*/
            } catch (InterruptedException e) { }

            //CRITICAL SECTION

            semaphore.release();

        }

    public static void main(String[] args) throws Exception {
        A thread1 = new A(5);
        A thread2 = new A(6);
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
    }
}