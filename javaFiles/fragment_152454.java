final int aInFoo = a;
Bar foo = new Bar {
    // Bar's method
    void xyz() {
        if (aInFoo == ... ) ...
    }
};