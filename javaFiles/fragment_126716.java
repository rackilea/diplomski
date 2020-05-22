public void updateRuns(String playerName, int runsScored) {
    Player player = players.remove(playerName);
    if (player == null) {
        player = new Player(playerName, runsScored);
    } else {
        scorepoard.remove(player);
        player = new Player(playerName, player.getRuns() + runsScored);
    }
    players.put(playerName, player);
    scoreboard.add(player);
}