public final class Operations {

    private Operations() {};

    public static final String op1 = "operation/path";
    public static final String op2 = "operation2/path";

    public enum Enum { 

        OPERATION1(op1),
        OPERATION2(op2);

        private final String path;

        Enum(final String path) {
            this.path = path;
        }

        public final String path() {
            return path;
        }
    }

}