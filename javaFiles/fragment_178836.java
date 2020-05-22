class MyClass {
    private int myInt;

    public MyClass(int myInt) {
        this.myInt = myInt;
    }

    @Overrides
    public String toString() {
        return "MyClass with value " + myInt;
    }
}