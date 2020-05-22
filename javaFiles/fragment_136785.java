class MyClass {
    int someVar = 1;

    MyClass setSomeVar(int i) {
        someVar = i;
        return this;
    }

    MyClass someFun() {
        System.out.println("something");
        return this;
    }
}

public static void main(String[] args) {
    MyClass newClass = new MyClass()
            .setSomeVar(2)
            .someFun();

    System.out.println(newClass.someVar);
}