public interface EventVisitor  {
    visit(FirstEvent firstEvent);
    visit(SecondEvent secondEvent);
}

public class FirstEvent {
    ...
    public void allowVisit(EventVisitor ev) {
        ev.visit(this); // calls the 'FirstEvent' overriden method
    }
    ...
}


public class SecondEvent {
    ...
    public void allowVisit(EventVisitor ev) {
        ev.visit(this); // calls the 'SecondEvent' overriden method
    }
    ... 
}

public class MyOtherObject implements EventVisitor, EventListener {
   ...
   public void signalEvent(Event e) {
       e.allowVisit(this);
   }

   public void visit(FirstEvent e) {
       // handle FirstEvent type
   }

   public void visit(SecondEvent e) {
       // handle SecondEvent type
   }