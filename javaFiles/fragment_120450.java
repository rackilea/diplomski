class RemoteSystem
{
    private final String name;

    RemoteSystem(String name)
    {
        this.name = name;
    }

    public String name()
    {
        return name;
    }
}

class RoundRobinLogic implements Runnable
{
    private static final AtomicInteger systemIndex = new AtomicInteger(1);

    private static final RemoteSystem[] systems = new RemoteSystem[] {
        new RemoteSystem("System1"),
        new RemoteSystem("System2"),
        new RemoteSystem("System3"),
        new RemoteSystem("System4"),
    };

    public static final Queue<String> output = new ConcurrentLinkedDeque<>();

    @Override
    public void run()
    {
        RemoteSystem system = systems[systemIndex.incrementAndGet() % systems.length];

        // Sending the request to right system
        output.add("Request to " + system.name());
    }
}