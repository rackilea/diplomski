class Base {
    protected int n;

    public Base(int n) {
        this.n = n;
    }
}

class Derived extends Base {
    protected int n; // POOR PRACTICE, don't do this

    public Derived(int n) {
        super(n / 2);
        this.n = n;
    }

    public void show() {
        System.out.println("this.n  = " + this.n);
        System.out.println("super.n = " + super.n);
    }
}