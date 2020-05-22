public void incrementA(View view) {
    pointsTeamA++;
    if (pointsTeamA == 1) displayA(15);
    if (pointsTeamA == 2) displayA(30);
    if (pointsTeamA == 3) displayA(40);

    if (pointsTeamA == 4) {
        displayGamesA(gameTeamA = gameTeamA + 1);
        displayA(pointsTeamA = 0);
    }
    if (gameTeamA == 6) {
        if (set == 1) {
            displaySet1A(gameTeamA);
            displayGamesA(gameTeamA = 0);
            set++; // Adds to the set variable, making it 2
        } else if (set == 2) {
            displaySet2A(gameTeamA);
            displayGamesA(gameTeamA = 0);
        }
    }

}