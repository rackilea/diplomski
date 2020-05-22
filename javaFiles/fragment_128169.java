public abstract class ProcessHandler {

         private final ExecutorService executorServiceProcess;
         private final List<Process> processList;
         private int poolSize;

         protected ProcessHandler(int poolSize) {
             executorServiceProcess = Executors.newFixedThreadPool(poolSize);
             processList = new ArrayList<>();
             this.poolSize = poolSize;
         }

          public void postInit(Process process) {
             for (int i = 0; i < poolSize; i++) {
                    processList.add(process);
                    executorServiceProcess.submit(process);    
              }  
          }

         public void shutdown() {
                Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    for (Process process : processList) {
                      process.shutdown();
                    }
                    executorServiceProcess.shutdown();
                    try {
                      executorServiceProcess.
                        awaitTermination(1000, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException ex) {
                      Thread.currentThread().interrupt();
                    }
                  }
                });
         }
 }