public class Foo {
    private String name; 

    public static void someClassMethod() { System.out.println("associated with a class"); }

    public Foo(String n) { this.name = n; }

    public String getName() { return this.name; }
    public void setName(String n) { this.name = n; }
    public void doAnotherThing() { 
       Foo.someClassMethod();   // This is what is really happening when you call a static method in an non-static method.
    }
}