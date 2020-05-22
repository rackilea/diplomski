public class VisibilityMap {
    public final int sizeX, sizeY;
    private boolean[] map;

    public VisibilityMap(int sizeX, int sizeY) {
        assert sizeX >= 0 && sizeY >= 0: "invalid arguments";
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        map = new boolean[sizeX * sizeY];
    }

    public boolean get(int x, int y) {
        if(x < 0 || sizeX <= x || y < 0 || y <= sizeY)
            return false;
        return map[y * sizeX + x];
    }

    public boolean set(int x, int y, boolean value) {
        if(x < 0 || sizeX <= x || y < 0 || sizeY <= y)
            return false;
        map[y * sizeX + x] = value;
        return true;
    }

    public void updateVisibilityAround(int x, int y) {
        boolean valid = set(x, y, true);
        assert valid: "position out of bounds!";
        set(x + 1, y, true);
        set(x - 1, y, true);
        set(x, y + 1, true);
        set(x, y - 1, true);
    }
}