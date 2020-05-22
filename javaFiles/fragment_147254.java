public void foo(String... names) {
}

public void bar1() {
    // Does allocate array on each call
    foo("x", "y", "z");
}

private static final String[] EXISTING_ARRAY = new String[10];

public void bar2() {
    // No allocation
    foo(EXISTING_ARRAY);
}