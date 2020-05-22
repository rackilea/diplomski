public class Robot {
    private int serial;

    //ctor, getters, setters etc etc

    public int toInt() {
        return serial;
    }

    public static int toInt(Robot robot) {
        return robot.toInt();
    }
}