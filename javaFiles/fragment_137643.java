int winner = 2;
for (int[] winningPosition : winningPositions) {

    //Checking SharedPreferences Themes
    int themeChosen = Utils.loadPreferences(getBaseContext(), "theme", 0);

    if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
            && gameState[winningPosition[1]] == gameState[winningPosition[2]]
            && gameState[winningPosition[0]] != 2) {

        //Someone has won!
        gameIsActive = false; //Disable Game Playablity

        winner = gameState[winningPosition[0]];
        break;
    } else if(gameMoves >= 9) {
        gameIsActive = false;
    }
}