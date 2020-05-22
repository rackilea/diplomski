class C {
    private final int taxos = 4;

    public int test() {
        final int a = 7;
        final int b = this.taxos;
        return a % b;
    }
}