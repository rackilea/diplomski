interface Foo {
    void doIt(String what, int times);
}

class Bar implements Foo {
    public void doIt(String andNowForSomeThingCompetelyDifferent, int theLarch) {}
}