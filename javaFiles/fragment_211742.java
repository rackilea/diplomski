int best = 0, index = 0;
for (int q = 0; q <= numberOfPlayers; q++){
   score = checkValue(deck);
   if (best < score){
      index = q;
      best = score;
   }
   String name = playerNames.get(q);
   currentScore.add(score);
   System.out.println(name +" drew a "+ deck.get(0) + " worth " + score + " points!"); //Print player 1's card
   deck.remove(0); //Remove card
   players.put(name, players.get(name).intValue() - score);
   }
System.out.println("Best player in this round: " + playerNames.get(index);