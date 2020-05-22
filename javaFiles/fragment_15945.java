interface InterfaceA {
    public void doSomething();
}

interface InterfaceB extends InterfaceA {
    @Override
    public default void doSomething() {...} // Provides a default implementation
}