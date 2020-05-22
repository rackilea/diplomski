public void doSomething(){
    Class1 class1 = new Class1();
    class1.method1();
    callIt(class1);
}

void callIt(Class1 class1) {
    class1.method2();
}