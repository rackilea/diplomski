class C1 {
    private final Provider<C2> c2;
    @Inject
    C1(Provider<C2> c2) {
        this.c2 = c2;
        ...
    }
}