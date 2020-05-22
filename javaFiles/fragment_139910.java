class Base {
    private int n;

    public Base(int n) {
        this.n = n;
    }

    public int getN() {
        return this.n;
    }
}

class Derived extends Base {
    private int n;

    public Derived(int n) {
        super(n / 2);
        this.n = n;
    }

    public int getN() {
        return this.n;
    }

    public void show() {
        System.out.println("this.getN()  = " + this.getN());
        System.out.println("super.getN() = " + super.getN());
    }
}