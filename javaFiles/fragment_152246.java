public void method1(){
    A a = new A();
    if (!a.method2()) {
        method3(); //<-- block not entered if method2() returns true.
    }
}