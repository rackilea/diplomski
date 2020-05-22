public interface MouseTarget {
    public int getTargetX();
    public int getTargetY();

    public default void moveMouseHere(Robot robot) {
        robot.moveMouse(this.getTargetX(), this.getTargetY());
    }
}