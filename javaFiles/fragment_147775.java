private final BlockingQueue<Integer> edgeAlerts;

    public Clock(double instructionsPerSecond, BlockingQueue<Integer> edgeAlerts)
    {
        this.edgeAlerts = edgeAlerts;
        executionSpeed = instructionsPerSecond;
        System.out.println("[Clock] Execution speed set to " + executionSpeed + "Hz. (" + timePeriod() + "s per instruction.)");
    }