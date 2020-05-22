public static MyEnum getByNumber(int n) {
    for (final MyEnum value : values()) {
        if (value.n == n) {
            return value;
        }
    }
    throw new IllegalArgumentException("No MyEnum found for n: " + n);
}