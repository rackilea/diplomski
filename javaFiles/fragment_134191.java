public class Foo {

    static { new Foo(); }

    static{ System.out.println("static code"); }

    public Foo() { 
       System.out.println("non static code");
       System.out.println("constructor"); 
    }

    public static void main(String[] args) {}
}