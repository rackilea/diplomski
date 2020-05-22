interface Foo {
    void doIt(String what, int times);
}

class Bar implements Foo {
    public void doIt(int times, String what) {}
}