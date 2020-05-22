int numberOfPlayers = 30;
int pointsClubA = 0, pointsClubB=0, pointsClubC=0;
String winner = "";

for (int i=0; i< numberOfPlayers ; i++)
{
    print "What is the number just finished?"
    input backnumber;

    if  (backnumber >=700 && backnumber <= 709)
    {
         pointsClubA++;
    }
    else  if  (backnumber >=800 && backnumber <= 809)
    {
         pointsClubB++;
    }
    else  if  (backnumber >=900 && backnumber <= 909)
    {
         pointsClubC++;
    }
    else
    {
         print ("invalid");
    }


   print "On position nr",(i+1),"its the runner with backnummer",backnumber,;
} // End of for loop

   int winningScore = Math.max (pointsClubA,pointsClubB, pointsClubC);

   if (pointsClubA == winningScore)
   {
       winner = "Team A"
   }  
   // Use if here instead of else if , because multiple winners are possible. 
   if (pointsClubB == winningScore)
   {
       if ("".equals(winner))
           winner = " and Team B"
       else
           winner = "Team B"
   }   
   if (pointsClubC == winningScore)
   {
       if ("".equals(winner))
           winner = " and Team C"
       else
           winner = "Team C"
   }           
   // Multiple winners are possible
   print "Match Won By : " +winner;

   // Sample outputs are:
   // Match won by Team A
   // Match won by Team B and Team C