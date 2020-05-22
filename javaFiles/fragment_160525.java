class Bar {
    static int i = 1;
    static {i += 1;}
    static int j = i;
}

class Foo {
    static int i = 1;
    static int j = i;
    static {i += 1;}

    public static void main(String[] args) {
        System.out.println("Foo.j = " + Foo.j);
        System.out.println("Bar.j = " + Bar.j);
    }
}