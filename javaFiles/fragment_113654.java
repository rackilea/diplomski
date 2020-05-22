class Test {
    private static void xxx(String s) {
        //do something with string
    }
    private static void yyy(Consumer<String> c) {
        c.accept("hello");
    }
    public static void zzz() {
        yyy(Test::xxx);
    }
}