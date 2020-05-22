if (pointsTeamA >= 4) {
    if (pointsTeamA - pointsTeamB >= 2) {   // if team A wins

        displayGamesA(gameTeamA = gameTeamA + 1);
        displayA(pointsTeamA = 0);
        displayB(pointsTeamB = 0);
        displayDeuceA(null);
        displayDeuceB(null);
   } else if (pointsTeamA - pointsTeamB == 1) { // score up by one

    // code for displaying "Advantage"  
   } else { // scores are tied
    // code for displaying "Deuce"
   }
}