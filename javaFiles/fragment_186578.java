public class ProducerConsumerTest {

    public static void main(String[] args) {
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;

        Thread producer = new Thread(new A(buffer, maxSize));
        Thread consumer = new Thread(new B(buffer));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producer);
        executorService.submit(consumer);
    }

}