public abstract class MyEvent extends AbstractEvent {
    public abstract void visit(Visitor v);
}

public class Event1 extends MyEvent{
    public void visit(Visitor v) {
        v.visit(this); // calls visit(Event1)
    }
}

public class Event2 extends MyEvent{
    public void visit(Visitor v) {
        v.visit(this); // calls visit(Event2)
    }
}

public class Event3 extends MyEvent{
    public void visit(Visitor v) {
        v.visit(this); // calls visit(Event3)
    }
}