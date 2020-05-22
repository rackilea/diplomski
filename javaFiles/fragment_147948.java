public static int getRoundsWon(double[] guessPrice, double exactPrice) {
        //first set (temporary) the first player as the winner (and its difference as the minimum)
        double minValue = Math.abs(exactPrice-guessPrice[0]);
        int roundWinner = 0;
        for (int k=1;k<guessPrice.length;k++) {  //then check for all other players
            double diff = Math.abs(exactPrice-guessPrice[k]);
            if (diff<minValue) { //if we found a new minimum
                minValue=diff; //store the new minimum
                roundWinner=k; //and set the new temporary winner
            }
        }
        return roundWinner; //return the actual winner
    }