public interface ModelListener {
   public void execute(Model context);
}

public class Model { 
    private List<ModelListener> listeners;

    public Model() {
      this.listeners = new ArrayList<ModelListener>();
    }

    public void addListener(ModelListener listener) {
      this.listeners.add(listener);
    }

    public void dispatch() {
      for (ModelListener listener: listeners) {
        listener.execute(this);
      }
    }