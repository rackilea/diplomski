// Three threads: one thread for the database writer, two threads for the plugin processors
final ExecutorService executor = Executors.newFixedThreadPool(3);

final BlockingQueue<Map<String, String>> queue = new LikedBlockingQueue<>();

Future future = executor.submit(new Runnable () {
    public void run() {
        Map<String, String> map;
        try {
            while(true) {
                // blocks until a map is available in the queue, or until interrupted
                map = queue.take();
                // write map to database
            }
        } catch (InterruptedException ex) {
            // IF we're catching InterruptedException then this means that future.cancel(true)
            // was called, which means that the plugin processors are finished;
            // process the rest of the queue and then exit
            while((map = queue.poll()) != null) {
                // write map to database
            }
        }
    }
}

for (ModuleRegistration.ModulesHolderEntry entry : ModuleRegistration.getInstance()) {
    executor.submit(new Runnable () {
        public void run() {
            final Map<String, String> response = entry.getPlugin().process(outputs);
            // put the response map in the queue for the database to read
            queue.offer(response);
        }
    }
}

// this interrupts the database thread, which sends it into its catch block
// where it processes the rest of the queue and exits
future.cancel(true); // interrupt database thread

// wait for the threads to finish
executor.awaitTermination(5, TimeUnit.MINUTES);