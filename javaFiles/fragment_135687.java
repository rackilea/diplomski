if(this.player.isAlive() && !this.currentOpponent.isAlive() && opponents.size() != 0 ) {
        System.out.println("Do you want to fight another opponent? yes or run?");
        if(input.contains("yes")){
        this.selectRandomOpponent();
        this.battle(); // <-- look at that line of recursion right there
     }