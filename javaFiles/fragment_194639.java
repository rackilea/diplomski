public void foo() {
    System.out.println("foo");
    return;
}

public void foobar() {
    foo();
    System.out.println("bar");
}