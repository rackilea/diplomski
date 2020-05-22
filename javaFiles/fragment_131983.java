public static void main(String[] args) throws InterruptedException {
    ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
    ReadThread readThread = new ReadThread(queue, "numbers.txt");
    MultiplyThread multiplyThread = new MultiplyThread(queue);
    Thread reader = new Thread(readThread);
    Thread multiplicator = new Thread(multiplyThread);
    multiplicator.start();
    reader.start();

    reader.join();
    multiplyThread.stop();
    multiplicator.join();
}