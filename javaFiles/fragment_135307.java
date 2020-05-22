abstract class SuperA {
    protected abstract Object getObj();

    public void print() {
        System.out.println(getObj());
    }
}

class A extends SuperA {
    @Override
    protected Object getObj() {
        // Your implementation
        return null; // return what you want
    }
}

class B extends A {
    @Override
    protected Object getObj() {
        // Your implementation
        return null; // return what you want
    }

    public static void main(String[] args) {
        B b = new B();
        b.print();
    }
}