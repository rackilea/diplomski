public class GameModel extends ViewModel {
     public final LiveData<Game> gameLiveData = new LiveData<>();

     public GameModel() {
         // trigger game load.
     }

     void doAction() {
         // depending on the action, do necessary business logic calls and update the gameLiveData.
     }
}

public class Game {
    public static final int CROSS = 1; 
    public static final int ZERO = 0;

    public int pos1 = -1; // Default values are -1, when the position is yet to be played
    public int pos2 = -1;
    public int pos3 = -1;
    public int pos4 = -1;
    public int pos5 = -1;
    public int pos6 = -1;
    public int pos7 = -1;
    public int pos8 = -1;
    public int pos9 = -1;
}