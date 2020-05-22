public TestArray(int val) {
    for (int i = 0; i < val; i++) {       
        Thread thread = new Thread(new runThread());
        thread.start();
        thread_lib.addThread(thread);       
    }
}