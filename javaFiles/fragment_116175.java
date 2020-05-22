public class Jar
{

    private int position;
    private Stone stone;
    private Player pos;

    public String toString() {
        if (stone == null) {
            return "[]" + "(" + getPosition() + ")";
        }
        return "[" + stone.toString() + "]" + "(" + getPosition() + ")";
    }

    public Stone getStone() {
        return stone;
    }