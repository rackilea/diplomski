class Foo {
    public Foo(String a) {s = a;}
    public String s;
    int hashCode() {return s.hashCode();}
    boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Foo)) return false;
        return ((Foo)other).s.equals(s);
    }
}