import java.util.LinkedHashSet;

class Experimental {
  static class PathFinder {
    final int gridSize;
    final boolean [] [] isBlocked;
    final Coord goal;
    final LinkedHashSet<Coord> path = new LinkedHashSet<>();
    final Random gen = new Random();

    PathFinder(int gridSize, int nBlocked) {
      this.gridSize = gridSize;
      this.isBlocked = new boolean[gridSize][gridSize];
      this.goal = new Coord(gridSize - 1, gridSize - 1);
      // This gets really inefficient if nBlocked is too big.
      for (int n = 0; n < nBlocked; ++n) {
        int x, y;
        do {
          x = gen.nextInt(gridSize);
          y = gen.nextInt(gridSize);
        } while (isBlocked[x][y] || (x == gridSize - 1 && y == gridSize - 1));
        isBlocked[x][y] = true;
      }
    }

    void searchFrom(Coord coord) {
      if (path.contains(coord)) return;
      path.add(coord);
      if (coord.equals(goal)) System.out.println(path);
      if (coord.x > 0 && !isBlocked[coord.x - 1][coord.y])
        searchFrom(new Coord(coord.x - 1, coord.y));
      if (coord.y > 0 && !isBlocked[coord.x][coord.y - 1])
        searchFrom(new Coord(coord.x, coord.y - 1));
      if (coord.x < gridSize - 1 && !isBlocked[coord.x + 1][coord.y])
        searchFrom(new Coord(coord.x + 1, coord.y));
      if (coord.y < gridSize - 1 && !isBlocked[coord.x][coord.y + 1])
        searchFrom(new Coord(coord.x, coord.y + 1));
      path.remove(coord);
    }

    void printAllPaths() {
      searchFrom(new Coord(0, 0));
    }

    static class Coord {
      final int x, y;
      public Coord(int x, int y) {
        this.x = x;
        this.y = y;
      }
      @Override
      public boolean equals(Object obj) {
        if (obj instanceof Coord) {
          Coord other = (Coord) obj;
          return x == other.x && y == other.y;
        }
        return false;
      }
      @Override
      public int hashCode() {
        return Integer.hashCode(x) ^ Integer.hashCode(-y);
      }
      @Override
      public String toString() {
        return '(' + Integer.toString(x) + ',' + Integer.toString(y) + ')';
      }
    }
  }

  public static void main(String[] args) {
    new PathFinder(4, new boolean [] [] {
      { false, false, false, false },
      { false, false, true, false },
      { true, false, false, false },
      { false, false, false, false },
    }).printAllPaths();
  }
}