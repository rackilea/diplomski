public class Derived extends Base {
    public static void main(String ... args) {
        System.out.println(new Derived().createInstance());
    }
}

abstract class Base {
    public Base createInstance() {
        //using reflection
        try {
            return getClass().asSubclass(Base.class).newInstance();
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}