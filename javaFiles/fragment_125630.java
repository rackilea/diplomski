class MineSweeper implements GameInterface
{
    // your code
}

class Mario implements GameInterface
{
   // your code
}

 public enum GameType
{
  MINESWEEPER
  {
     public GameInterface createGame()
     {
      return new MineSweeper();
     }
  },

  MARIO
  {
     public GameInterface createGame()
    {
      return new Mario();
     }
  }

   public abstract GameInterface createGame();
}