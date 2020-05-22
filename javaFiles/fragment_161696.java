public class Event { EventType getType (); }
 // extend Event for special cases that require additional attributes…

 public class EventDispatcher {
       Map<Class<? extends Event>, List<Observer>> observers;
       void send (final Event e) {
            for (Observer o : observers.get(e.getClass())) {
                  o.receiveEvent (e);
            }
       }
  }