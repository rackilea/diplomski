package game;

public class RockPaperScissors
{
  static int player1wins = 0;
  static int player2wins = 0;
  static int draw = 0;

  public static void main(String[] args) throws InterruptedException
  {
    int cycles = 1000;
    Player player1 = new Player("Player-1", cycles);
    Player player2 = new Player("Player-2", cycles);

    new Thread(player1).start();
    new Thread(player2).start();


    for (int i = 0; i < cycles; i++)
    {
      Choice choice1;
      Choice choice2;

      choice1 = player1.getChoice();
      System.out.println("Value 1 is definitely generated");

      choice2 = player2.getChoice();
      System.out.println("Value 2 is definitely generated");

      System.out.printf("\n%3d\nPlayer1 - %8s\nPlayer2 - %8s\n", i, choice1.name(), choice2.name());

      if (choice1 == choice2)
      {
        draw++;
        System.out.println("Draw!");
      }
      else if (choice1 == Choice.ROCK)
      {
        if (choice2 == Choice.PAPER)
        {
          player2wins++;
          System.out.println("2 wins!");
        }
        else
        {
          player1wins++;
          System.out.println("1 wins!");
        }
      }
      else if (choice1 == Choice.PAPER)
      {
        if (choice2 == Choice.SCISSORS)
        {
          player2wins++;
          System.out.println("2 wins!");
        }
        else
        {
          player1wins++;
          System.out.println("1 wins!");
        }
      }
      else if (choice1 == Choice.SCISSORS)
      {
        if (choice2 == Choice.ROCK)
        {
          player2wins++;
          System.out.println("2 wins!");
        }
        else
        {
          player1wins++;
          System.out.println("1 wins!");
        }
      }
    }
    System.out.printf("Player 1 wins - %3d times;\n" +
        "Player 2 wins - %3d times;\n" +
        "Draw result   - %3d times\n\n", player1wins, player2wins, draw);

    System.out.printf("Player-1 cycles left = %d\n" +
        "Player-2 cycles left = %d\n", player1.getCounter(), player2.getCounter());
  }
}