class B extends A {

    static {
        INSTANCE = new B();
    }

    @Override
    protected String getURL0() {
        return "application-specific url";
    }
}