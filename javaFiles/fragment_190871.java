interface BarProcess{
    void foo();
}

public class DefaultBarProcess implements BarProcess{
    void foo() {
       System.out.println("Foo from A");
    }
}

public class AnotherBarProcess implements BarProcess{
    void foo() {
       System.out.println("Foo from B");
    }
}

class A {

    private BarProcess barProcess;

    public A(Bar barProcess){
      this.barProcess = barProcess;
    }

    void bar() {
        barProcess.foo();
    }
}

class B extends A {  //deprecated! No need to exist

}