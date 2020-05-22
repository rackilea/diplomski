public static void main(String[] args)
    {
        SharedSpace sharedSpace = new SharedSpace(new LinkedBlockingQueue<Integer>(1));
        new Thread(new Producer(sharedSpace)).start();


        Consumer consumerRunnable = new Consumer(sharedSpace);
        new Thread(consumerRunnable).start();

        CyclicBarrier barrier = new CyclicBarrier(3,consumerRunnable);

        new Thread(new EndUser(barrier,consumerRunnable)).start();
        new Thread(new EndUser(barrier,consumerRunnable)).start();
        new Thread(new EndUser(barrier,consumerRunnable)).start();
    }