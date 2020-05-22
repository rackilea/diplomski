public MyClass {
    private final String name;

    @Inject
    public MyClass(NameInjector nameInjector) {
        this.name = nameInjector.get(this, "foo", true);
    }
}