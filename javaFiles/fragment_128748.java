void foo() {
    while(true) {
        bar();
    }
}

void bar() {
    myRetransform();
    System.out.println("a");
}

void myRetransform() {
    // This is where a retransformation of class A, method bar, is triggered.
}