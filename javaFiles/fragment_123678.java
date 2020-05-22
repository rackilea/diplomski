public static final List<String> fooArray;
static {
    List<String> a = new ArrayList<>();
    Collections.addAll(a, Foo.a, Foo.b, Foo.c);
    fooArray = Collections.unmodifiableList(a);
}
// (There's probably some really nifty Java8 way to do that as a one-liner...