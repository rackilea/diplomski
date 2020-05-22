class SuperClass {
    public void doSomething() {
        doSuperClassyThing();
    }

    public final void doSuperClassyThing() { // cannot be overridden
        ...
    }
}