class WrapperProxy extends MyClass {
    private MyClass delegate = new MyClass();

    @Override
    public void run() {
       delegate.run();
    }
}