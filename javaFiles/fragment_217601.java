public class Game {
    private BooleanProperty[][] grid;

    public Game() {
        grid = new BooleanProperty[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                BooleanProperty p = new SimpleBooleanProperty();
                p.set(false);
                grid[i][j] = p;
            }
        }
    }

    // other methods
}