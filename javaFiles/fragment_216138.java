int currentPlayerIndex = players.indexOf(currentPlayer);
int nextPlayerIndex = currentPlayerIndex + (direction0fPlay ? 1 : -1);

// Ensure index is in array
nextPlayerIndex = (nextPlayerIndex + players.size()) % players.size();

return players.get(nextPlayerIndex);