public enum RandomUtils {

    INSTANCE;

    private Random rand = new Random();

    public int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}