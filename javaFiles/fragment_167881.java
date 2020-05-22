public void playerRolls(){
   rollDice(); //HERE

   System.out.print(PlayerScore);
   if(PlayerScore >= 100)
       System.out.println("You have won the game of Pig!");
}