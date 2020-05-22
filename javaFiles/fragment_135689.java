public boolean endGame() {
     boolean restart = false;
     String input = reader.getInput();   
     int pointsWon = this.random.nextInt(91) + 10;
        this.player.setReputation(this.player.getReputation() + pointsWon);
        System.out.println(this.player.getName() + " wins the game and an extra " + pointsWon + " reputation");
        System.out.println("");
    if(this.player.isAlive() && !this.currentOpponent.isAlive() && opponents.size() != 0 ) {
        System.out.println("Do you want to fight another opponent? yes or run?");
        if(input.contains("yes")){
        this.selectRandomOpponent();
        //this.battle(); // nope
        restart = true;
      }
    } else if(!this.currentOpponent.isAlive()){
        System.out.println("You died and left the game");
    }

    if(!restart) { // changed here slightly
        System.out.println("Game Over.");
    }
    return restart;
}