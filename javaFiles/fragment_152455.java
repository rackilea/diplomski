final int aInFoo = a;
Bar foo = Bar {
    int a1 = aInFoo;

    // Bar's method
    void xyz() {
        if (this.a1 == ... ) ...
    }
};