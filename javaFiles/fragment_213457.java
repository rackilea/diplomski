// **Please** choose better names than this in your real code.
public class MyWrapperBackedByMyObject implements MyWrapperInterface {
    private final MyObject delegate;

    @Inject
    MyWrapperObject(Foo foo, @Assisted Bar bar) {
        delegate = new MyObject(foo, bar);
    }

    @NotOnWeekends  // Example of how you might do method interception
    public void orderPizza() {
       delegate.orderPizza();
    }
}