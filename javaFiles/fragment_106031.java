private void printScores(Player... players) {
    for (int i = 0; i < players.length; ++i) {
        Player player = players[i];
        String name   = player.getName();
        int    score  = player.getScore();
        // Print name and score followed by a newline
        System.out.format("%s: %d%n", name, score);
    }
}

// Print a single player, 3 players, and all players
printScores(player1);
System.out.println();
printScores(player2, player3, player4);
System.out.println();
printScores(playersArray);

// Output
Abe: 11

Bob: 22
Cal: 33
Dan: 44

Abe: 11
Bob: 22
Cal: 33
Dan: 44