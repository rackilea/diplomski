public class BetterSingletonClass {
    private BetterSingletonClass me = null;
    private Queue<Y> someQueue = new LinkedList<>();

    private BetterSingletonClass(X x) {
        someQueue.add(new Y("Hello", x));
    }

    public BetterSingletonClass getInstance (X x) {
        if ( me == null ) {
            me = new BetterSingletonClass(x);
        }
        return me;
    }

}