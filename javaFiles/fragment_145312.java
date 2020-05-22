// Replace Process process by a list of Process
List<Process> processes = new ArrayList<Process>();

private final Thread shutdownHook = new Thread() {
    @Override
    public void run() {
      for (Process process : processes)
        process.shutdown();
      executorServiceProcess.shutdown();
    }
};

public ProcessHandler(Process process, int poolSize) {
    this.executorServiceProcess = Executors.newFixedThreadPool(poolSize);
    Runtime.getRuntime().addShutdownHook(shutdownHook);     
    for (int i = 0; i < poolSize; i++) {
      // Get a deep copy of the process
      Process p = process.clone();
      processes.add(p);
      executorServiceProcess.submit(p);
    }
}