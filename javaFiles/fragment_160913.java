public class Mouse {
    private Cage cage;
    public Mouse(Cage cage) {
        this.cage = cage;
    }
    public void eat() {
        cage.changeCageStrength();
    }
}