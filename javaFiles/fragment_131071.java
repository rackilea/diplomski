scheduler.scheduleAtFixedRate(new Runnable() {
  @Override
  public void run() {
    System.out.println("Testing...");
  }
}, 60, 24*60*60,TimeUnit.SECONDS);