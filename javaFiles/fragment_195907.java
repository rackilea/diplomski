abstract class Base {
    protected String field = "foo";
    public abstract void method();

    public Base() {
        method();
    }
}

class Derived extends Base {
    protected String field = "bar";

    public Derived() {
        super();
    }

    public void method() {
        System.out.println("value of field is "+field);
    }
}

class TestX{
    public static void main(String[] args) {
        new Derived();
    }
}