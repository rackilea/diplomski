//Listner.java
interface Listener {
  void onStateChange(X2.State currentState);
}

//X2.java
import java.util.ArrayList;
import java.util.List;

public class X2 {
  private State currentState = State.INACTIVE;

  private List<Listener> listeners = new ArrayList<>();

  enum State {
    ACTIVE, INACTIVE
  }

  public State getState() {
    changeState(); // It shouldn't be called here. I just need to simulate the state changing inside randomly
    return currentState;
  }

  private void changeState() {
    if (Math.random() <= 0.1) {
      currentState = State.ACTIVE;
    } else {
      currentState = State.INACTIVE;
    }
    for(Listener listener:listeners){
      listener.onStateChange(currentState);
    }
  }

  public void registerListener(Listener listener){
    listeners.add(listener);
  }

  public static void main(String[] args) throws InterruptedException {
    X2 x = new X2();
    TimeInactiveListener timeInactiveListener = new TimeInactiveListener();
    x.registerListener(timeInactiveListner);
    while (true) {
      x.getState();
      System.out.println(timeInactiveListner.getTimeInactive());
      Thread.sleep(1000);
    }
  }
}

class TimeInactiveListener implements  Listener {
  private long timeLastChanged = System.currentTimeMillis();
  private X2.State oldState = X2.State.INACTIVE;
  private long timeInactive = 0; // total time of being inactive
  @Override
  public void onStateChange(X2.State currentState) {
    long now = System.currentTimeMillis();
    if (oldState == X2.State.INACTIVE && currentState == X2.State.ACTIVE) {
      long elapse = now - timeLastChanged;
      timeInactive += elapse;
    }
    if (oldState != currentState) {
      timeLastChanged = now;
    }
    oldState = currentState;
  }

  public long getTimeInactive() {
    return timeInactive;
  }
}