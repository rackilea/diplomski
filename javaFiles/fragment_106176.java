public enum Foo {
    ONE(1), TWO(2);

    private final int number;

    private Foo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}