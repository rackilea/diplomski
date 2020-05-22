public class BombFactory {

    private final Random rand;

    public BombFactory() {
        this.rand = new Random();
    }

    public Bomb makeBomb(int lowerboundX, int rangeX, int yPos) {
        final int xPos = lowerboundX + rand.nextInt(rangeX);
        return new Bomb(xPos, yPos);
    }

}