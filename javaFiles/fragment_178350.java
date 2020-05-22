public class X {

  private long timeInactive = 0; // total time of being inactive

  private long timeLastChanged = System.currentTimeMillis();
  private State currentState = State.INACTIVE;

  enum State {
    ACTIVE, INACTIVE
  }

  public State getState() {
    changeState(); // It shouldn't be called here. I just need to simulate the state changing inside randomly
    return currentState;
  }

  private void changeState() {
    State oldState = currentState;
    if (Math.random() <= 0.1) {
      currentState = State.ACTIVE;
    } else {
      currentState = State.INACTIVE;
    }
    long now = System.currentTimeMillis();
    if (oldState == State.INACTIVE && currentState == State.ACTIVE) {
      long elapse = now - timeLastChanged;
      timeInactive += elapse;
    }
    if (oldState != currentState) {
      timeLastChanged = now;
    }
  }

  public long getTotalTimeInActive() {
    return timeInactive;
  }


  public static void main(String[] args) throws InterruptedException {
    X x = new X();
    while (true) {
      x.getState();
      System.out.println(x.getTotalTimeInActive());
      Thread.sleep(1000);
    }
  }
}