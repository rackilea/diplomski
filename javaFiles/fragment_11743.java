class Test {
    int a = foo("hello");
    int b = foo("world");
    static int foo(String s) {
        System.out.println(s);
        return 3;
    }
}