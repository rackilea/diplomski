public static boolean choosePlayer()
{
   String whatPlayer = input("Are you Player 1 or Player 2?");
   boolean player1;
   if (whatPlayer.equalsIgnoreCase("Player 1"))
   {
       player1 = true;
   }    
   else
   {
       player1 = false;
   }  
   return player1;
}