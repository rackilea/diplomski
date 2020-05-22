class RevertingBoolean {
    private long timeToRevert = Long.MAX_VALUE;
    private boolean value;
    private boolean defaultValue;

    void setDefaultValue(boolean value) {
        this.defaultValue = value;
    }

    void setRevertAfter(long revertAfter) {
        this.timeToRevert = System.currentTimeMillis() + revertAfter;
    }

    void setValue(boolean value) {
        this.value = value;
    }

    boolean getValue() {
        if (System.currentTimeMillis() > timeToRevert) {
            this.value = this.defaultValue;
            timeToRevert = Long.MAX_VALUE;
        }
        return this.value;
    }
}