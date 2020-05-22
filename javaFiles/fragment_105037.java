// Shared queue
final Queue<String> messages = new ConcurrentLinkedQueue<>();

// Non-blocking consumer
ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
ses.scheduleAtFixedRate(new Runnable(){
    @Override
    public void run() {
        // non-blocking
        while((String message = messages.poll()) != null) {
            // do something
        }
    }
}, 0, 10, TimeUnit.MILLISECONDS);

// Blocking producer
Scanner sc = new Scanner(System.in);
while(sc.hasNext()) {
    messages.add(sc.next());
}