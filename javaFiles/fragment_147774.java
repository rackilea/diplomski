private final BlockingQueue<Integer> edgeAlerts;

    public ClockThread(String name, double insPerSec, BlockingQueue<Integer> edgeAlerts)
    {
        threadName = name;
        this.edgeAlerts = edgeAlerts;
        System.out.println("Clock thread initialised");
        instructionsPerSecond = insPerSec;
    }