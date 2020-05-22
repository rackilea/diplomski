public class ObserverVisitor1 implements IObserverVisitor{

    public void visit(IObserver obsrvr, Observable obsrvable, Object o) {
        System.out.println("updated one");
    }

}