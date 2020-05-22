private String s;

public String foo() {
    s += "foo1"
    bar();
    s += "foo2"
    return s;
}
private String bar() {
    s += "bar1"
    return s;
}