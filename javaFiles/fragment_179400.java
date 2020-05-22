public boolean checkAllMatchesFound() {       
     for (int i=0; i<MatchingGame.NUMBER_OF_CARDS; i++){
           if (!cards[i].isFacingUp())
                return false;
     }
     return true;
}