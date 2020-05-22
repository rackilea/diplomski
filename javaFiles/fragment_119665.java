class HSequenceBuilder {
    private long id = 0;
    private final Map<Integer, H> map = new HashMap<Integer, H>();

    static H create(int next) {
        H h = new H(id, next, Collections.unmodifiableMap(map));
        map.put(id, h);
        id++;
        return h;
    }

    static H create() {
        create(id + 1);
    }

}

class H {
    private final id;
    private final Map<Integer, H> map;
    private final int next;

    H(int id, int next, Map<Integer, H> map) {
        this.id = id;
        this.next = next;
        this.map = map;
    }

    int getId() { return id; }
}
HSequenceBuilder builer = new HSequenceBuilder();
H h1 = builder.create(); // 1.
H h2 = builder.create(); // 2.
H h3 = builder.create(h2.getId()); // 3.