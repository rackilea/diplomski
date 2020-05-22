class B {
    @NotNull(groups = Ignored.class)
    String x;
}

class A {
    @Valid
    B b;

    @NotNull
    String y;
}