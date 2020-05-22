interface IOne {

    void method();
}

interface ITwo {

    void method();
}

public class A
    implements IOne, ITwo {

    // Anonymous inner class that implements ony IOne
    private final IOne one = new IOne() {

        @Override
        public void method() {
            System.out.println("IOne");
        }
    };

    // Anonymous inner class that implements ony ITwo
    private final ITwo two = new ITwo() {

        @Override
        public void method() {
            System.out.println("ITwo");
        }
    };

    @Override
    public void method() {
        System.out.println("A");
    }

    // Method that delegates to IOne
    public void methodIOne() {
        this.one.method();
    }

    // Method that delegates to ITwo
    public void methodITwo() {
        this.two.method();
    }
}