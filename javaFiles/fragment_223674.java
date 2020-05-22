public List<Player> GetHealthyPlayer(List<Player> PlayersList )
{
  List<Player> Players = new ArrayList<Player>();
  int PlayerCount = 0;
  for (Player pl: PlayersList )
  {
      if(pl.getHealth() > 0)
      { 
         Players.add(pl);
         PlayerCount++;
         if(PlayerCount == 2) //Since we need only two healthy player
             break;
       }
  }
  if(PlayerCount != 2) 
      throw Exception("Two healthy players not found "); //Or you Can return null and check
  return Players;
}