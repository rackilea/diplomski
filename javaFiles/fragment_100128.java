public class PlayerStats implements Comparable<PlayerStats> {

    private String playerName;
    private int playerScore;
    private String gameDate;

    public PlayerStats(String playerName, int playerScore, String gameDate) {
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.gameDate = gameDate;
    }

    @Override
    public int compareTo(PlayerStats o) {
        return Integer.compare(this.playerScore, o.playerScore);
    }

    @Override
    public String toString() {
        return "Player: " + playerName + " Score: " + playerScore + "Date: " + gameDate;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getGameDate() {
        return gameDate;
    }
}