class C1 {
    private final C2 c2;
    @Inject
    C1(C2 c2) {
        this.c2 = c2;
        ...
    }
}

class C2 {
    private final C1 c1;
    @Inject
    C2(C1 c1) {
        this.c1 = c1;
        ...
    }
}