public static void main(String[] args) {
    MyThread runnable = new MyThread();
    Thread mine = new Thread(runnable);
    mine.start();
    mine.join();
    runnable.getResult();
}