class MyClass {
    private final MyClass myInstance;
    public MyClass(MyClass myInstance) {
        this.myInstance = myInstance;
    }
    public MyClass() {
        this.myInstance = this;
    }
}