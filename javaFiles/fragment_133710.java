public class GameLogic {

    private static final GameLogic INSTANCE = new GameLogic();

    private SuperField superField;

    private GameLogic() {
        this.superField = new SuperField();
    }

    public static GameLogic getGameLogic() {
        return GameLogic.INSTANCE;
    }

    public SuperField getGameField(){
        return this.superField;
    }
}