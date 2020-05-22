static void search(final SearchListener listener, final ProgressWindow window){
  ExecutorService execs = Executors.newFixedThreadPool(Runtime
            .getRuntime().availableProcessors());
  Collection<Callable<Void>> processes = new LinkedList<>();
  for (int i = 0; i < 100; i++) {
    processes.add(new Callable<Void>() {
        @Override
        public Void call() throws Exception {
            // This method needs to ensure that 
            // what ever it does to the UI, it is done from within
            // the context of the EDT!!
            progressWindow.addProgress();
            return null;
        }
        });
    }
    try {
        execs.invokeAll(processes);
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        execs.shutdown();
    }
    System.out.println("finish");
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            listener.searchCompleted();
        }
    });        
}