public enum Keys {

    TEST1(0x01), TEST2(0x02);

    int value;
    private Keys(int value) {
        this.value = value;
    }

    public getValue() {
        return value;
    }
}