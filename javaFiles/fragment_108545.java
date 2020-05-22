public class ObserverVisitor2 implements IObserverVisitor{

    public void visit(IObserver obsrvr, Observable obsrvable, Object o) {
        System.out.println("updated two");
    }
}