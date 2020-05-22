public class ObjectWrapper {
    private CreationStrategy strategy;
    private boolean objectCreated;
    private Object wrappedObject;

    public ObjectWrapper(CreationStrategy strategy) {
        this.strategy = strategy;
    }

    synchronized Object getWrappedObject() {
        if (!objectCreated) {
            wrappedObject = strategy.createObject();
            objectCreated = true;
        }
        return wrappedObject;
    }

    public interface CreationStrategy {
        Object createObject();
    }
}