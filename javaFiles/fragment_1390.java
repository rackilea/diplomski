public final class ModeColorVisitor implements ModeVisitor<Color> {
    public Color visitOn() {
       return getOnColor();
    }

    public Color visitOff() {
       return getOffColor();
    }

    public Color visitStandby() {
       return getStandbyColor();
    }

}