public Pairs method() {
    return new Pairs();
}

// make the names here meaningful for what your method actually does
public static class Pairs {
    private static class Pair {
        String s;
        int i;
    }

    private final List<Pair> pairs = new ArrayList<>();

    private Pairs() {}

    public Pairs add(String s, int i) {
        Pair p = new Pair();
        p.s = s;
        p.i = i;
        pairs.add(p);
        return this;
    }

    public void run() {
        for (Pair p : pairs) {
            ... do method's work here ...
        }
    }
}