for (Iterator<Player> playerIter = players.iterator(); playerIter.hasNext();) 
{
  Player p = playerIter.next();
  p.addCard(deck.dealCard());
  p.addCard(deck.dealCard());
}