public final class Member extends java.lang.Enums<Members> {
    public static final Members A = new Member(1) {
        public String toString() { return "A:"+size; }
    };
    public static final Members B = new Member(2) {
        public String toString() { return "B:"+size; }
    };
    public static final Members C = new Member(3) {
        public String toString() { return "C:"+size; }
    };
    private final int size;
    protected Member(int size) { this.size = size; }
}