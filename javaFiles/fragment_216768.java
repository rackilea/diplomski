import java.util.ArrayList;
import java.util.List;

public class DiceGameModel {

    private static final int maxPlayers = 4;

    private int playerNumber;

    private List<PlayerModel> players;

    public DiceGameModel() {
        this.players = new ArrayList<PlayerModel>();
        this.playerNumber = -1;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public static int getMaxPlayers() {
        return maxPlayers;
    }

    public void addPlayer(PlayerModel player) {
        this.players.add(player);
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public PlayerModel getNextPlayer() {
        this.playerNumber++;
        this.playerNumber %= getNumberOfPlayers();
        return getCurrentPlayer(playerNumber);
    }

    public PlayerModel getCurrentPlayer(int playerNumber) {
        return players.get(playerNumber);
    }

}