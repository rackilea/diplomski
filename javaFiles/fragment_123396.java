Players minScorePlayer = playersList2.get(0);
for (Players player: playersList2) {
   if (player.getScore() < minScorePlayer.getScore()) {
      minScorePlayer = player;
   }
}
//now minScorePlayer variable contains the reference to a player with the minimal score