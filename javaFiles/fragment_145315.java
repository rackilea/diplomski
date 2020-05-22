public final class ProcessHandler {
  private final ExecutorService executorServiceProcess;
  private final List<AProcess> processes = new ArrayList<AProcess>();
  private final Thread shutdownHook = new Thread() {
    @Override
    public void run() {
      for (AProcess process : processes)
          process.shutdown();
      executorServiceProcess.shutdown();
    }
  };

  public ProcessHandler(ProcessA process, int poolSize) {
    this.executorServiceProcess = Executors.newFixedThreadPool(poolSize);
    Runtime.getRuntime().addShutdownHook(shutdownHook);     
    for (int i = 0; i < poolSize; i++) {
      ProcessA p = new ProcessA(process.getName(), process.getProperties());
      processes.add(p);
      executorServiceProcess.submit(p);
    }
  }

  public ProcessHandler(ProcessB process, int poolSize) {
    this.executorServiceProcess = Executors.newFixedThreadPool(poolSize);
    Runtime.getRuntime().addShutdownHook(shutdownHook);     
    for (int i = 0; i < poolSize; i++) {
      ProcessB p = new ProcessB(process.getName(), process.getProperties());
      processes.add(p);
      executorServiceProcess.submit(p);
    }
  }

  public void shutdown() {
    Runtime.getRuntime().removeShutdownHook(shutdownHook);
    shutdownHook.start();
    try {
      shutdownHook.join();
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }
}