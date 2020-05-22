public class Scratch {
    enum lower { a, b, c };
    enum upper { A, B, C };

    static <T extends Enum<T>> T translate(Enum<?> aFrom, Class<T> aTo) {
        return aTo.getEnumConstants()[aFrom.ordinal()];
    }

    public static void main(String[] args) {
        for (lower ll : lower.values()) {
            upper uu = translate(ll, upper.class);
            System.out.printf("Upper of '%s' is '%s'\n", ll, uu);
        }
        for (upper uu : upper.values()) {
            lower ll = translate(uu, lower.class);
            System.out.printf("Lower of '%s' is '%s'\n", uu, ll);
        }
    }
}