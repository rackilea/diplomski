class Foo {
    static { bar = generateValue(); }                  //originally 3rd
    private static int generateValue() { return 123; } //originally 2nd
    private final static int bar;                      //originally 1st

    public static void main(String[] args) {
        System.out.println("Foo.bar = " + Foo.bar);
    }
}