Collection<Callable<Void>> tasks = new ArrayList<Callable<Void>();
for (int p1 = 0; p1 < allPlayers.length; p1++)
{
    for (int p2 = p1 + 1; p2 < allPlayers.length; p2++)
    {    
        for (int t = 0; t < trials; t++)
        {
            final int player1 = t % 2 == 0 ? p1 : p2;
            final int player2 = t % 2 == 0 ? p2 : p1;
            final Player[] players = new Player[] { allPlayers[player1], allPlayers[player2] };
            final int trial = t;
            tasks.add(new Callable<Void>() {
               public Void call() {
                 game.newGame();

                 while (!game.isFinished())
                    game.playNthMove(players[game.currentPlayer()].move(game));

                 data[p1][p2][t] = getCharValue(game.getOutcome()[t % 2 == 0 ? 0 : 1]);
                 data[p2][p1][t] = getCharValue(game.getOutcome()[t % 2 == 0 ? 1 : 0]);
                 return null;
              }
           });
        }
    }
}
executor.invokeAll(tasks); // called on an exector, will wait for all tasks to complete