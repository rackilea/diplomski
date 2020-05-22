public class Game
{
private Player[] playerArray;
[...]
public void createPlayer(String name1, String name2)
  {
    this.playerArray = new Player[2];        
    playerArray[0] = new Player(name2);           
    playerArray[1] = new Player(name1);
  }