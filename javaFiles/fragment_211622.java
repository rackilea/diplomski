import java.lang.reflect.Constructor;

public abstract class Base {

    public Base() {
        this(1);
    }

    public Base(int i) {
        super();
    }

    public Base createInstance() throws Exception {
        Class<?> c = this.getClass();
        Constructor<?> ctor = c.getConstructor(new Class[] { int.class });
        return ((Base) ctor.newInstance(new Object[] { 1 }));
    }

    public abstract int getValue();

}