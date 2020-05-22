Map<String, Player> players;
SortedSet<Player> scoreboard;

public void updateRuns(String playerName, int runsScored) {
    Player player = players.get(playerName);
    if (player == null) {
        player = new Player(playerName, runsScored);
    } else {
        scorepoard.remove(player);
        player.addRuns(runsScored);
    }
    scoreboard.add(player);
}