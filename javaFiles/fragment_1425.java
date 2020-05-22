class MyClass {
    public void myMethod () {
        System.out.println("myMethod");
    }

    public void myMethod (int i) {
        System.out.println(i * 2);
    }

    public void myMethod (String s) {
        System.out.println("Hello, " + s);
    }

    public static void main (String[] args) {
        MyClass a = new MyClass();
        a.myMethod(); // "myMethod"
        a.myMethod(33); // "66"
        a.myMethod("Jeremy") // "Hello, Jeremy"
    }
}