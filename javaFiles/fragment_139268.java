public class Testing_gameNum
{
   public static final int amt = 1;
   public static void main(String[] args)
   {
      Scanner console = new Scanner(System.in);
      guessCounter(console);
   }

   public static int game(Scanner console)
   {
      Random rand = new Random();
      int guess = 0;
      int guessNum = 0;
      System.out.printf("I'm thinking of a number...", amt);
      System.out.println();
      int num = 1;
      do
      {
         System.out.println("Your guess? ");
         guess = console.nextInt();
         guessNum += amt;
      }
      while (guess != num);
      return guessNum;
   }
   public static void guessCounter(Scanner console)
   {
      int gameNum = 1;
      do
      {
         int guessNum = game(console);
         if (guessNum == 1)
         {
            System.out.printf("You won in %d guesses!", guessNum);
            System.out.println();
         }
         gameNum = gameNum + 1;
         System.out.println("Do you want to play again?");
         String play = console.next();
      }
      while (play.equals("y"))
      System.out.println("Number of games: " + gameNum);
   }
}