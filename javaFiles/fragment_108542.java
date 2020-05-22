public class Observable1 extends AbstractObservable {
    public void changeSomething() {
      setChanged();
      notifyObservers();
    }
}