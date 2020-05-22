class A {
    class C {}
    class B extends C {}
    B b() {
        return new B();
    }
}
public class So9961167 {
    public static void main(String[] args) {
        A a=new A();
        A.C b=a.b();
        if(b instanceof A.B) {
            A.B b2=(A.B)b;
            System.out.println("it worked!");
        }
    }
}