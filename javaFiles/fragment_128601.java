public static void main(String[] args) throws Exception {
    CopyThread copyThread1 = new CopyThread();
    CopyThread copyThread2 = new CopyThread();

    copyThread1.start();
    copyThread2.start();
}