class Foo<Bar> {
    Bar[] bars = (Bar[])new Object[5];
    public Bar get(int i) {
        return bars[i];
    }
    public void set(int i, Bar x) {
        bars[i] = x;
    }
    public Bar[] getArray() {
        return bars;
    }
}

// in some method somewhere:
Foo<String> foo = new Foo<String>();
foo.set(2, "hello");
String other = foo.get(3);
String[] allStrings = foo.getArray();