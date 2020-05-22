static enum BooleanEnum {
    FALSE(false), TRUE(true);

    private BooleanEnum(boolean value) {
        this.value = value;
    }
    private final boolean value;

    public boolean value() {
        if (System.currentTimeMillis() % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}