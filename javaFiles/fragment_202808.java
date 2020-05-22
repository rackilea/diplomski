class Example {
    private int x;

    class Inner extends Example {{
        x = 1;       // refers to the outer instance
        super.x = 2; // refers to the inner instance
    }}

    public static void main(String[] args) {
        Example outer = new Example();
        Example inner = outer.new Inner();
        System.out.println(outer.x); // prints 1
        System.out.println(inner.x); // prints 2
    }
}