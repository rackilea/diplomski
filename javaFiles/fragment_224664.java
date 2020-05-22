public class nVector<T extends nVector<?>> {
    Class<T> cls;
    int i; // <-- default value 0. Should probably be set in the constructor
           //     or with a setter method.
    public nVector(Class<T> cls) {
        this.cls = cls;
    }

    public T add(T a) {
        T b = null;
        try {
            b = cls.newInstance();
            b.i = this.i + a.i; // <-- equivalent, thx @LukeLee
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return b;
    }
}