public class TestForkJoinPoolEnd {
    private static final BlockingQueue<String> QUEUE = new LinkedBlockingQueue<>();
    private static final int MAX_SIZE = 5000;
    private static final int SPEED_UP = 100;

    public static void main(String[] args) {
        ForkJoinPool customThreadPool = new ForkJoinPool(12);
        ForkJoinTask<?> future = customThreadPool.submit(
            () -> makeList()
                    .parallelStream()
                    .forEach(TestForkJoinPoolEnd::process));
        QUEUE.offer("Theard pool started up");

        int counter = MAX_SIZE + 1;
        while (!future.isDone()) try {
            String s = QUEUE.poll(1, TimeUnit.MILLISECONDS);
            if (s != null) {
                System.out.println(s);
                counter--;
            }
        } catch (InterruptedException e) {}

        for(;;) {
            String s = QUEUE.poll();
            if (s == null) break;
            System.out.println(s);
            counter--;
        }
        System.out.println("counter = " + counter);
        System.out.println("isQuiescent = " + customThreadPool.isQuiescent()     + " isTerminating " +
                "= " + customThreadPool.isTerminating() + " isTerminated = "
                + customThreadPool.isTerminated() + " isShutdown =" +     customThreadPool.isShutdown());

        customThreadPool.shutdown();
    }

    static List<String> makeList() {
        return IntStream.range(0, MAX_SIZE)
            .mapToObj(i -> makeString())
            .collect(Collectors.toList());
    }

    static String makeString() {
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = random.nextInt('z' - 'a' + 1) + 'a';
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    static int toSeed(String s) {
        return s.chars().sum() / SPEED_UP;
    }

    static void process(String s) {
        long start = System.nanoTime();
        try {
            TimeUnit.MILLISECONDS.sleep(toSeed(s));
        } catch (InterruptedException e) {

        }
        long end = System.nanoTime();
        QUEUE.offer(s + " slept for " + (end - start)/1000000 + " milliseconds");
    }
}