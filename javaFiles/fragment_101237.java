enum State {
    IDLE, MOVING, ATTACKING(false), MOVING_FAST;

    private boolean someFlag;

    State(boolean someFlag) {
        this.someFlag = someFlag;
    }

    State() {
        this(true);
    }

    public boolean isSomeFlag() {
        return someFlag;
    }
}