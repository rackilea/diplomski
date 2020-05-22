public class Tile {
    public static final int SIZE = 16;

    private short id;
    private short health;
    private boolean solid;

    public void saveInto(ByteBuffer buf) {
        buf.putShort(id);
        buf.putShort(health);
        buf.put(solid ? 1 : 0);
        ...
        // make sure to always write the same tile size!
        // fill up with placeholder if necessary!
    }

    public static Tile loadFrom(ByteBuffer buf) {
        Tile tile = new Tile();
        tile.id = buf.getShort();
        tile.health = buf.getShort();
        tile.solid = buf.get() == 1;
        ...
    }
}