int gamesPlayed = 0;
int gamesRequested = 3; // or get this from the user

while (gamesPlayed < gamesRequested){
    String player1Choice = in.nextLine();
    if(!"".equals(player1)){
    // your code
        gamesPlayed++;
    } else {
        System.out.print("Rock, Paper, or Scissors?: ");
    }
}