class Foo {
    static int peek() { return j; }
    static int i = peek();
    static int j = 1;

    public static void main(String[] args) {
        System.out.println("Foo.i = " + Foo.i);
    }
}