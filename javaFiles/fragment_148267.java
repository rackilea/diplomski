public class Data {

    private int numUninitialized;
    private int[][] structure;

    public Data(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("You can't create a Data object with an argument that isn't a positive integer.");
        }
        structure = new int[x][y];
        int numUninitialized = x * y;
    }

    public void generateRandom() {
        if (isFull()) {
            // do whatever you want when the array is full
        } else {
            // Calculate the random space you want to set a value for
            int x = ThreadLocalRandom.current().nextInt(structure.length);
            int y = ThreadLocalRandom.current().nextInt(structure[0].length);
            if (structure[x][y] == 0) {
                // A new, uninitialized space
                numUninitialized--;
            }
            // Populate the space with a random value
            structure[x][y] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    public boolean isFull() {
        return 0 == numUninitialized;
    }
}