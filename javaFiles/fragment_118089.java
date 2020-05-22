public abstract class HandlerChain<V extends MyObject> {

    private List<MyObjectHandler<V>> handlers;

    public HandlerChain(List<MyObjectHandler<V>> handlers) {
        this.handlers = handlers;
    }

    public List<V> doChain(List<V> objects) {
        for (MyObjectHandler<V> handler : handlers) {
            objects = handler.handle(objects);
        }
        return objects;
    }

}