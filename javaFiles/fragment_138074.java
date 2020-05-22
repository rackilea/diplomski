public enum CustomType {
    TYPE_A(513, 520, 528, 530, 532),
    TYPE_B(501, 519, 529),
    TYPE_C();

    private static final Map<Integer, CustomType> typeMappings = new HashMap<>();

    static {
        for (CustomType ct : values()) {
            for (int v : ct.mapto) {
                typeMappings.put(v, ct);
            }
        }
    }

    private final int mapto[];
    CustomType(int ... mapto) {
        this.mapto = mapto;
    }
}