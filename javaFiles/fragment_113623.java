int numOfPlayers = 2; //can receive this from user input

ArrayList<Player> players = new ArrayList<Player>();
for(int x=0; x<numOfPlayers; x++)
    numOfPlayers.add(new Player("Player " + (x+1)));

for(int x=0; x<numOfRounds; x++){
    for(int y=0; y<players.size(); y++)  //iterate through all players
        rollDice(players.get(y));
    decideWinner(players);               //decide the winner from all the players
}