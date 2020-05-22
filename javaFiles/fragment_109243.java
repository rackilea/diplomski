public class Stick {

    int diameter;
    Stick stick;

    public Stick(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public Stick getNextStick() {
        return stick;
    }

    public void setNextStick(Stick stick) {
        this.stick = stick;
    }
}