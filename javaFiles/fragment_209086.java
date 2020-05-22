final Runnable example = new Runnable() {
  Runnable runAndReturn() {
    run();
    return this;
  }

  @Override public void run() {
    System.out.println(example);
  }
}.runAndReturn();