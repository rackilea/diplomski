public class Chunk {
    public static final int WIDTH = 16;
    public static final int HEIGHT = 16;
    public static final int SIZE = WIDTH * HEIGHT * Tile.SIZE;

    private Tile[][] tiles;

    public void saveInto(ByteBuffer buf) {
        for (int x = 0; x < WIDTH; ++x) { 
            for (int y = 0; y < HEIGHT; ++y) {
                tiles[x][y].saveInto(buf);
            }
        }
    }

    public static Chunk loadFrom(ByteBuffer buf) {
        Chunk chunk = new Chunk();
        for (int x = 0; x < WIDTH; ++x) { 
            for (int y = 0; y < HEIGHT; ++y) {
                tiles[x][y] = Tile.loadFrom(buf);
            }
        }
    }
    ...
}