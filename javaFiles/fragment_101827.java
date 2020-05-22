class A {
    @Override
    public String toString() {
        return "A's toString()";
    }
}

class B extends A {
    @Override
    public String toString() {
        return super.toString() + " " + "B's toString()";
    }
}

B b = new B();
System.out.println(b); // prints "A's toString() B's toString()"