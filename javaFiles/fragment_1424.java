class MyClass {
    public void myMethod () {
        System.out.println("MyClass");
    }
}

class MySubClass extends MyClass {
    @Override
    public void myMethod () {
        System.out.println("MySubClass");
    }

    public static void main (String[] args) {
        MyClass a = new MyClass();
        a.myMethod(); // "MyClass"
        MySubClass b = new MySubClass();
        b.myMethod(); // "MySubClass"
    }
}