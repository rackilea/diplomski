public class B {
    private String name;
    private A a;

    public B(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public void setA(A a) {
        this.a = a;
    }

    public A getA() {
        return this.a;
    }
}