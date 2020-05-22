public class Detonator {
    private Bomb bomb;

    public Detonator(Bomb bomb) {
        this.bomb = bomb;
    }

    public void pushButton() {
        // do some stuff to test, and at the end
        bomb.explode();
    }
}