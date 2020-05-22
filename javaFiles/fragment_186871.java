public enum Bezel {
    // Note different naming convention in Java
    FLASHING((byte) 0),
    SOLID_ON((byte) 1),
    NONE((byte) 254);

    private final byte value;

    private Bezel(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}