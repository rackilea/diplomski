private void test_Method() throws InterruptedException {
        synchronized (MyThread.class) {
            System.out.println("test_Method " + Thread.currentThread().getName());
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (i == Integer.MAX_VALUE / 2) {
                    Thread.sleep(2000);
                    System.out
                            .println("Leaving test_Method in " + Thread.currentThread().getName());
                    return;
                }
            }
        }
    }