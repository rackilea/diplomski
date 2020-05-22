class Foo {
    public static Bar hop(Bar x, Bar y, Bar z) { ... }
}

TriFunction<Bar> pf = Foo::hop;
TriFunction<Integer> pg = (x, y, z) -> x + y + z;
Bar bara = pf.apply(a, b, c);