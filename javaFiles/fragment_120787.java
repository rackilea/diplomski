public interface GameModel {
    public int[][] getMaze();
    public int[] getPlayerLocation();
    public void setPlayerLocation(int[] location);
    public void update(Set<Direction> directions);
}

public interface GameController {
    public int[][] getMaze();
    public int[] getPlayerLocation();
    public void setDirectionPressed(Direction direction, boolean pressed);
    public void start();
}

public interface GameView {
    public void update();
    public void setController(GameController controller);
    public GameController getController();
}