public static void main(String[] args) {
    new HelloWorld().test(); // Need an instance of HelloWorld to call test on.
}

public void test() { //<-- not a static method.
    System.out.println("Hello World!");
}