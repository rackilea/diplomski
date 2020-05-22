class MyClass {
    public void myMethod () { }
}

void somewhere () {
    List<MyClass> items = ...;
    getSecondItem(items).myMethod();
}