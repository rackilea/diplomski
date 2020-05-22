public class Dice {
    private final int[] faces;
    private java.util.Random random = new java.util.Random();
    public Dice(final int[] faces) {
        this.faces = faces;
    }
    public int getNextRoll() {
        return faces[random.nextInt(faces.length)];
    }
}