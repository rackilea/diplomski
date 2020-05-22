import java.util.Random;
import java.util.Scanner;

class Blackjack
{
    public static void main(String[] args)
    {
        Random r = new Random();
        String name;
        Scanner scannerIn = new Scanner(System.in);

        boolean playing = true;
        int card1 = 1 + r.nextInt(11);
        int card2 = 1 + r.nextInt(11);
        int dcard1 = 1 + r.nextInt(11);
        int dcard2 = 1 + r.nextInt(11);

        int ptotal = card1 +card2;
        int dtotal = dcard1 +dcard2;

        System.out.println("Welcome to Blackjack ! " );
        System.out.println("Score as close to 21 without going over to win ");
        System.out.println("What is your name?");
        name = scannerIn.nextLine();
        System.out.println("Hello " + name);
        System.out.println("Let's play some BlackJack!");
        System.out.println("The dealer shows: \n\t\t" +dcard1 );
        System.out.println("Your first card is: \n\t\t " +card1 );
        System.out.println("Your second card is: \n\t\t" +card2  );
        System.out.println("Giving you a grand total of: " +ptotal );


        while (playing)
        {
            System.out.println("Would you like to (H)it or (S)tick?");
            String a = scannerIn.nextLine();
            if(a.toLowerCase().equals("h"))
            {
                int newCard = 1 + r.nextInt(11);
                System.out.println("Your next card is " +newCard );
                ptotal = ptotal +newCard;
                System.out.println("Giving you a new total of "+ptotal);
                if ((ptotal >=22))
                {
                    System.out.println("You Busted! \nSorry! you lose");
                    playing = false;
                }

            }else if(a.toLowerCase().equals("s"))
            {
                System.out.println("You stick at " +ptotal );
                System.out.println("Now it's the dealers turn\n Dealer must draw until 17");
            }
            else
            {
                System.out.println("Please press H or S");
            }

        }
        scannerIn.close();
    }
}