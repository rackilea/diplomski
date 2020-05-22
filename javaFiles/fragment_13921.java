public class Test {

public static class A {
    protected String field = "I'm class A";
}

public static class B extends A {
    protected String field = "I'm class B";
}

/**
 * @param args
 */
public static void main(String[] args) {
    B b = new B();
    System.out.println(b.field); // prints "I'm class B"
    System.out.println(((A) b).field); //prints "I'm class A"
}

}