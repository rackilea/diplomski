class TileIterator implements Iterator<Tile> {

    int x = 0, y = -1;
    int newX, newY;
    Tile[][] grid;

    TileIterator(Tile[][] grid) {
        this.grid = grid;
        updateNewIndex();
    }

    public boolean hasNext() {
        if (newX == -1) {
            return false;
        }
        return true;
    }

    public Tile next() {
        x = newX;
        y = newY;
        updateNewIndex();
        if (x == -1) {
            throw new NoSuchElementException("no more elements left");
        }
        return grid[x][y];
    }

    private void updateNewIndex() {
        newX = x;
        newY = y;
        do {
            newY++;
            if (newY == grid[newX].length) {
                newY = 0;
                newX = newX + 1;
                if (newX == grid.length) {
                    newX = newY = -1;
                }
            }
        } while (newX != -1 && grid[newX][newY] == null);
    }
}