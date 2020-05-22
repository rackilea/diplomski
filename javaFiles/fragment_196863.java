final ExecutorService executor = Executors.newSingleThreadExecutor();

// Code that runs in the first button
Runnable worker1 = new Runnable() {
  @Override
  public void run() {
    System.out.println("Thread 1");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace(System.err);
    }
    SwingUtilities.invokeLater(this::updateGUI);
  }

  private void updateGUI() {
    System.out.println("Done with thread 1");
    //update GUI
  }
};
executor.execute(worker1);

// Code that runs in the second button
Runnable worker2 = new Runnable() {
  @Override
  public void run() {
    System.out.println("Thread 2");
    SwingUtilities.invokeLater(this::updateGUI);
  }

  private void updateGUI() {
    System.out.println("Done with thread 2");
    //update GUI
  }
};
executor.execute(worker2);