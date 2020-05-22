public static void main(String[] args) throws Exception {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    final Semaphore sem = new Semaphore(1, true);
    Runnable r1 = new Runnable() {
        public void run() {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A");
            sem.release();
        }
    };
    Runnable r2 = new Runnable() {
        public void run() {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
            sem.release();
        }
    };
    Runnable r3 = new Runnable() {
        public void run() {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("C");
            sem.release();
        }
    };

    for (int i = 0; i < 10; i++) {
        executor.submit(r1);
        executor.submit(r2);
        executor.submit(r3);
    }

    executor.shutdown();
}