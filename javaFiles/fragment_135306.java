class A {
    private int x = 5;

    protected int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    public void print() {
        // getX() is used such that 
        // subclass overriding getX() can be reflected in print();
        System.out.println(getX());
    }
}

class B extends A {
    public B() {
        // setX(10);  // perhaps set the X to 10 in constructor or in main
    }

    public static void main(String[] args) {
        B b = new B();
        b.setX(10);
        b.print();
    }
}