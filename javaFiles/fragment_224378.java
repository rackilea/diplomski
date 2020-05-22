class BaseClass {

    public void info() {
        System.out.println("base class");
    }
}

class DerivedClass extends BaseClass {

    @Override
    public void info() {
        System.out.println("derived class");
    }

    public void specialMethod() {
    }
}

public class Test {

    public static void main(String[] args) {
        BaseClass b = new DerivedClass();
        b.info();
        System.out.println("Type of b: " + b.getClass());
        // not allowed:
        // b.specialMethod();
    }
}