enum MyEnum {
    G, C, A, T, U;

    static {
        C.complements = EnumSet.of(G);
        G.complements = EnumSet.of(C);
        A.complements = EnumSet.of(T);
        T.complements = EnumSet.of(A, U);
        U.complements = EnumSet.of(T);
    }

    private EnumSet<MyEnum> complements;

    public boolean complements(MyEnum other) {
        return complements.contains(other);
    }
}