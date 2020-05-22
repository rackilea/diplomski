public class GameAction
{
    private Consumer<Game> action;
    public void doAction(Game game) {
        action.accept(game); // e.g.: exchange money and items between two players
    }
}