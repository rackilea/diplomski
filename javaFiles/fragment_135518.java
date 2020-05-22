public interface Event {
    // general event information - date, message, meta data, etc....
}
public interface Listener { 
   public void listen(Event event);
}

public enum EventBus {
   INSTANCE;

   private List<Listener> listeners = new ArrayList<>;

   public void addListener(Listener newListener) {
       listeners.add(newListener);
   }

   public void notify(Event event) {
      for (Listener listener : listeners) {
         listener.listen(event);
      }
   }
}


public class Notifier {

    public void handlePointOfInterest(.....) {
        // do something interesting with the parameters, etc...
        Event event = // create a new event based on your needs
        EventBus.INSTANCE.notify(event);
        ...
    }
}