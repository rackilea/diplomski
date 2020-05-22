class Program {
    public static void main() {
        BlockingQueue<Double> queue = new ArrayBlockingQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}