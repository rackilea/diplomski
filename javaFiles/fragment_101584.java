class A {
    public static synchronized f() {...} //class level lock
    public static g() {...} //object level lock
}
public class TestA{
    public static void main(String[] args){
        A a = new A();
       //Thread 1:
       a.f();
       //Thread 2:
       a.g();
    }
}