class A {

    final int  x;

    public A(int x) {
        this.x = 0;
    }   
}

class B extends A {

    public B(int x) {
        super(getValueForX(x));
    }

    private static int getValueForX(int x) {

        return x > 5 ? x : 0;
    }
}