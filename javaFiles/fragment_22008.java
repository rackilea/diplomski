/*
           * rolls: number of times a dice is thrown
           * dice amount: number of di being thrown
           * diceSize: number of different results from rolling dice
           * number: number of times all dice land on number
           */
          static int rollDice(int rolls, int diceAmount, int diceSize, int number){
                int amount = 0;

                for (int i = 0; i < rolls; i++){
                    int[] dice = new int[diceAmount];
                    boolean alltrue = true;
                    for (int j = 0; j < diceAmount; j++){ //Roll all the dice to a random number by diceSize
                        dice[j] = (int)(Math.random ()*diceSize+1); 
                    }

                    for (int j = 0; j < diceAmount; j++){ //Recount all the dice rolled to see if they all landed the same way
                        if(dice[j] != number)
                             alltrue=false;
                }
                if(alltrue) //All dice were the number
                    amount++;

            }
            return amount;
      }