public class ReadingFile {
    public static void main(String[] args) {

        final int threadCount = 10;

        // BlockingQueue with a capacity of 200
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(200);

        // create thread pool with given size
        ExecutorService service = Executors.newFixedThreadPool(threadCount);

        for (int i = 0; i < (threadCount - 1); i++) {
            service.submit(new CPUTask(queue));
        }

        // Wait til FileTask completes
        service.submit(new FileTask(queue)).get();

        service.shutdownNow();  // interrupt CPUTasks

        // Wait til CPUTasks terminate
        service.awaitTermination(365, TimeUnit.DAYS);

    }
}

class FileTask implements Runnable {

    private final BlockingQueue<String> queue;

    public FileTask(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("D:/abc.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                // block if the queue is full
                queue.put(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class CPUTask implements Runnable {

    private final BlockingQueue<String> queue;

    public CPUTask(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String line;
        while(true) {
            try {
                // block if the queue is empty
                line = queue.take(); 
                // do things with line
            } catch (InterruptedException ex) {
                break; // FileTask has completed
            }
        }
        // poll() returns null if the queue is empty
        while((line = queue.poll()) != null) {
            // do things with line;
        }
    }
}