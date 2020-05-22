public class Thingy {
    private int a;
    private int b;

    public Thingy(a, b) {
        this.a = a;
        this.b = b;
    }

    public Thingy withA(int newA) {
        return new Thingy(newA, this.b);
    }

    public Thingy withB(int newB) {
        return new Thingy(this.a, newB);
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    // ...
}