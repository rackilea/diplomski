class C {
    public C(){    
        System.out.println("C constructor");
    }
}

class B extends C{
    public B() {
        System.out.println("B constructor");
    }

}
class A extends B{
    public A() {
        System.out.println("A constructor");
    }
}


public class Test {
    public static void main(String[] args) {
        new A();
    }
}