public static class MyPoJo {
    final String foo, bar;

    public MyPoJo(String foo, String bar) {
        this.foo = foo;
        this.bar = bar;
    }

    public String getFoo() {
        return foo;
    }

    public String getBar() {
        return bar;
    }

    public int getBaz() {
        return 5;
    }
}