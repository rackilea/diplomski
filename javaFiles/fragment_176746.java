private static class X {

    public X() {
    }
}

private static class Y {

    public Y() {
    }
}

private static class Z extends Y {

    public Z() {
    }
}

public void test() {
    Map<X, Y> map = new HashMap<>();
    // Both of these work fine.
    map.put(new X(), new Y());
    map.put(new X(), new Z());
}