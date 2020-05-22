public class Observable2 extends AbstractObservable {
    public void changeSomething() {
      setChanged();
      notifyObservers();
    }
}