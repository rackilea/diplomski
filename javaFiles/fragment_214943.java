/** <T> A subclass of Nexus */
abstract class Nexus<T extends Nexus<T>> { // This syntax lets you confine T to a subclass of Nexus
    private T next;

    protected Nexus() {
        this.add((T) this);
    }

    public T add(T obj) {
        // Delegate to HeadAndTail
        return getHeadAndTail().add(obj);
    }

    /** @return a static for the class */
    protected abstract HeadAndTail<T> getHeadAndTail();
}

/** Bundled into one Object for simplicity of API */
class HeadAndTail<T extends Nexus<T>> {
    T head = null;
    T tail = null;
    int num = 0;

    public T add(T obj) {
        obj.next = null;
        if (num++ == 0)
            head = tail = obj;
        else
            tail = tail.next = obj;

        return obj;
    }
}

class ConcreteNexus extends Nexus<ConcreteNexus> {
    // This is the static object all instances will return from the method
    private static HeadAndTail<ConcreteNexus> headAndTail = new HeadAndTail<ConcreteNexus>();

    protected HeadAndTail<ConcreteNexus> getHeadAndTail() {
        return headAndTail; // return the static
    }
}