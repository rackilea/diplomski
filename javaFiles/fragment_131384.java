abstract class A {
    private int a;

    protected A(int a) {
        this.a = a;
    }

    protected int get() {
        return this.a;
    }
}

class B
    extends A {

    B() {
        super(2);
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.get()); // 2
    }
}