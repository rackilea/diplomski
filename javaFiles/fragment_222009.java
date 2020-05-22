class Foo {
    Object[] bars = new Object[5];
    public Object get(int i) {
        return bars[i];
    }
    public void set(int i, Object x) {
        bars[i] = x;
    }
    public Object[] getArray() {
        return bars;
    }
}

// in some method somewhere:
Foo foo = new Foo();
foo.set(2, "hello");
String other = (String)foo.get(3);
String[] allStrings = (String[])foo.getArray();