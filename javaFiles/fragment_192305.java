public class Detonator {
    private Bomb bomb = new AtomicBomb();

    public void pushButton() {
        // do some stuff to test, and at the end
        bomb.explode();
    }
}