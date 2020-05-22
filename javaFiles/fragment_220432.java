public final class Descriptor {
    public final String acronym;
    private static final Hashtable<String, Descriptor> all = new Hashtable<String, Descriptor>();
    static {
        initialize();
    }
    private static void initialize() {
        new Descriptor("example001");
        new Descriptor("example002");
        new Descriptor("example003");
    }
    private Descriptor(String acronym) {
        this.acronym = acronym;
        if (all.contains(this.acronym)) {
            throw new RuntimeException("duplicate acronym: " + this.acronym);
        }
        all.put(this.acronym, this);
    }
    public static Descriptor valueOf(String acronym) {
        return all.get(acronym);
    }
    public String value() {
        return this.acronym;
    }
}