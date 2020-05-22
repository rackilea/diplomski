public BeanOfTargetPage {
    @ManagedProperty(value="#{param.foo}")
    private String foo;

    @PostConstruct
    public void init() {
        // Parameter 'foo' is available here.
    }

    // ...
}