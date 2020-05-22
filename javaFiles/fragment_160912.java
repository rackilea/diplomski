public class Cage {
    private Mouse foo;
    private int cageStrength;
    public Cage() {
        cageStrength = 1;
        foo = new Mouse(this);
    }
    public void changeCageStrength() {
        cageStrength--;
    }
}