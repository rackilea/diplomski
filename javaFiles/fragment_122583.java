class Child extends Base{

    void foo() {
        int x = getX(); // we can access the method since it is protected.
        setX(42);  // this works too.
    }
}