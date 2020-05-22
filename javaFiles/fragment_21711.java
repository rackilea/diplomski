/**
     * The timer thread. (and its the single thread to execute all the scheduled TimerTasks)
     */
  private final TimerThread thread = new TimerThread(queue);

  //Timer constructor
  public Timer(String name) {
            thread.setName(name);
            thread.start();
  }