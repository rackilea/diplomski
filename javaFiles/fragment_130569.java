public class SubA extends A {
    @Override
    public void m1() {
        // add extra functionalities
        super.m1(); // invoke existing functionalities
    }
}

public class SubB extends B {
    @Override
    public void m2() {
        // add extra functionalities
        super.m2(); // invoke existing functionalities
    }
}

public class MyClass {
    SubA a = new SubA();
    SubB b = new SubB();
    a.m1();
    b.m2();
}