class Outer {
    class Inner {
        void myMethod() {
            // This will print "Blah", from the Outer class' toString() method
            System.out.println(Outer.this.toString());

            // This will call Object.toString() on the Outer class' instance
            // That's probably what you need
            System.out.println(Outer.super.toString());
        }
    }

    @Override
    public String toString() {
        return "Blah";
    }

    public static void main(String[] args) {
        new Outer().new Inner().myMethod();
    }
}