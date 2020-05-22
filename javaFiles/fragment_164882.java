public class Main {
    static class A {
           public void someMethod() { System.out.println(this.getClass().getName()); }
    }
    static class B extends A{
           @Override
           public void someMethod() { System.out.println("Derived: " + this.getClass().getName()); }
    }
    public static void main(String[] args) {
        var myA = new A();
        myA.someMethod();
        myA = new B(); // does not fail to compile!
        myA.someMethod();
    }
}