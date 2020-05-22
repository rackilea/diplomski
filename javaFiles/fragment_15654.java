public enum Status {
    PLANNING("Planning", 100),
    DEVELOPMENT("Development", 200),
    PRODUCTION("Production", 300);

    private final String label;
    private final int code;

    private Status(String label, int code) {
        this.label = label;
        this.code = code;
    }

    public int getCode() { return this.code; }

    private static final Map<Integer,Status> map;
    static {
        map = new HashMap<Integer,Status>();
        for (Status v : Status.values()) {
            map.put(v.code, v);
        }
    }
    public static Status parse(int i) {
        return map.get(i);
    }
}