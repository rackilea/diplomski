public String foo(String s) {
    s += "foo1"
    bar(s);
    s += "foo2"
    return s;
}
private String bar(String s) {
    s += "bar1"
    return s;
}