class MainThreadClass implements InputListner {
  public MainThreadClass() {
    InputRunner inputRunner = new InputRunner();
    inputRunner.addInputListener(this);
    Thread t = new Thread(new InputThread())
    t.start();
  }

  @Override
  public void inputReceived() {
    //bla bla bla
  }
}

class InputRunner implements Runnable {
  ArrayList<InputListener> listeners = new ArrayList<InputLIsteners>();

  public void run() {
    //code to read input, when it is recieved execute fireInputReceived
  }

  public void addListener(InputListener listener) {
    listeners.add(listener);
  }

  public void fireInputReceived(String input) {
    //loop through all listeners
    //fire inputRecieved on each
  }
}

public Interface InputListener {
  public void inputReceived(String input);
}