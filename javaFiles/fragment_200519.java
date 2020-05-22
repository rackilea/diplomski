import java.util.Scanner;

public class assn10
{
    static double bal = 0.0;
    static double inc = 0.0;


    public static void main(String[] args)
    {
       Scanner stdIn = new Scanner(System.in);
       String act = "MUSH";

       while (act.charAt(0) != 'Q')
       {
           System.out.print((char)27 + "[2J");
           System.out.print("## IT\'S A BANK ##\nD - Deposit\nW - Withdraw\nI - Interest\nB - Balance\nQ - Quit\n\nAction:");
           act = stdIn.next();
           act = act.toUpperCase();
           switch (act.charAt(0))
           {
           case 'D':
               deposit(stdIn);
               break;
           case 'W':
               withdraw(stdIn);
               break;
           case 'I':
               interest(stdIn);
               break;
           case 'B':
               balance(stdIn);
               break;
           }
       }
   }

   public static void deposit(Scanner stdIn)
   {
       System.out.print((char)27 + "[2J");
       System.out.print("Deposit how much?:");
       inc = stdIn.nextDouble();

       while (inc < 0)
       {
           System.out.print("Deposits must be non-negative. Please try again:");
           inc = stdIn.nextDouble();
       }

       bal += inc;
   }

   public static void withdraw(Scanner stdIn)
   {
       System.out.print((char)27 + "[2J");
       System.out.print("Withdraw how much?:");
       inc = stdIn.nextDouble();

       while (inc < 0)
       {
           System.out.print("Withdrawalas must be non-negative. Please try again:");
           inc = stdIn.nextDouble();
       }
       while (inc > bal)
       {
           System.out.print("Insufficient funds. Please try a lower amount:");
           inc = stdIn.nextDouble();
       }

       bal -= inc;
   }

   public static void interest(Scanner stdIn)
   {
       System.out.print((char)27 + "[2J");
       inc = bal*.04;
       bal += inc;
       System.out.print("Interest accrued: $" + inc + "; press enter key to return to menu.");
       stdIn.nextLine();
       stdIn.nextLine();
   }

   public static void balance(Scanner stdIn)
   {
       System.out.print((char)27 + "[2J");
       System.out.print("Balance = $" + bal + "; press enter key to return to menu.");
       stdIn.nextLine();
       stdIn.nextLine();
   }
}