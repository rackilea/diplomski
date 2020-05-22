class A {}
class B extends A {}

public class Demo {

    public static void main(String[] args) {
        Object a = new A();
        Object b = new B();
        System.out.println(a.getClass().getName()); //prints A
        System.out.println(b.getClass().getName()); //prints B
    }

}