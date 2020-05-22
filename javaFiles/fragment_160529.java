class Foo { //Don't do this
    static int peek() { return j.hashCode(); } // NullPointerException here
    static int i = peek();
    static Object j = new Object();

    public static void main(String[] args) {
        System.out.println("Foo.i = " + Foo.i);
    }
}