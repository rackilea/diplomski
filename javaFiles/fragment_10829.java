abstract class A {

    final protected boolean b;

    A(boolean b) {
        this.b = b;
    }

    //No setter method
    //public abstract void setB(boolean b);
    public abstract boolean getB();
}

class C extends A {

    C(boolean b) {
        super(b);
    }

    @Override
    public boolean getB() {
        return b;
    }
}