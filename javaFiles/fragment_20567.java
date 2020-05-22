public interface IA {
    void f();
}
public interface IB {
    void g();
}
public class C implements IA, IB { 
    public void f() { ... }
    public void g() { ... }        
}
public class A {
    public void doSomething(IA anIA) {
        C aC = (C) anIA;
        aC.g(); // legal!
    }
}