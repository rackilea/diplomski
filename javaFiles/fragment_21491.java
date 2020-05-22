public class OvervableAnimal extends Observable implement Observer {
  private Class<?> animal;
  // constructor omitted
  public synchronized void update(Observable o, Object arg) {
    if (!animal.isInstance(arg))
      return; // not the right animal
    setChanged();
    notifyObservers(arg);
  }
}
ObserverClass obs;
ObserverAnimal obsHippo = new ObservableAnimal(Hippo.class);
obs.addObserver(obsHippo);
// use obsHippo if you want to be notified when a hippo has changed