public enum Fields implements MouseTarget {

    AGE_FIELD(778, 232), NAME_FIELD(662, 280);

    public int targetX;
    public int targetY;

    Fields(int targetX, int targetY) {
        this.targetX = targetX;
        this.targetY = targetY;
    }

    @Override
    public int getTargetX() {
        return (this.targetX);
    }

    @Override
    public int getTargetY() {
        return (this.targetY);
    }
}