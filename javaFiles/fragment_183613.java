public IFoo getiFoo() {
    if (iFoo == null) {
       iFoo = new FooImpl();
    }
    return iFoo;
}