public static void threadThis (int y){
    List<Thread> threads = Lists.newArrayListWithCapacity(y);
    for (int i = 0; i<y; i++) {
        Thread t1 = new Thread(){...};
        t1.start();
        threads.add(t1);
    }
    for (Thread t : threads) {
        t.join();
    }
}