boolean has_players = false;
Player player1;
Player player2;
synchronize (rankedPlayersWaitingForMatch) {
  if (rankedPlayersWaitingForMatch.get(rankedType).size() >= 2) {
    player1 = rankedPlayersWaitingForMatch.get(rankedType).remove();
    player2 = rankedPlayersWaitingForMatch.get(rankedType).remove();
    has_players = true;
  }
}

if(has_players){
  // ... I don't want this all to be synchronized, just after the first 2 remove()
}
else{
  // ...
}