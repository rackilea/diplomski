@Builder
public static class Foo<F, T> {

    // hide lombok's builder method:
    private static FooBuilder builder() {
        return new FooBuilder();
    }

}