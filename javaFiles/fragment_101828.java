class B extends A {
    @Override
    public String toString() {
        ...
    }

    public String parentsToString() {
        return super.toString();
    }
}

B b = new B();
b.parentsToString(); // will return the output of A's toString()