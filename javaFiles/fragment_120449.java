class RoundRobinLogic implements Runnable
{
    private static final AtomicInteger systemIndex = new AtomicInteger(1);

    public static final Queue<String> output = new ConcurrentLinkedDeque<>();

    @Override
    public void run()
    {
        if (systemIndex.incrementAndGet() % 2 == 0) {
            // Sending the request to first system
            output.add("Request to System1");
        } else {
            // Sending the request to second system
            output.add("Request to System2");
        }
    }
}