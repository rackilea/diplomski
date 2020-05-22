public class Subclass{
  private PropertyChangeSupport propChangeSupport = 
       new PropertyChangeSupport(this);
  private ArrayList store;

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propChangeSupport.addPropertyChangeListener(listener);
  }

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propChangeSupport.removePropertyChangeListener(listener);
  }


  public void add(T data)
    store.add(data);
    propChangeSupport.firePropertyChange(...);
  }


}