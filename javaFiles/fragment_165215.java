import java.util.Random;

public class DiceSimulation
{
    public static void main(String[] args)
    {
        final int NUMBER = 10000;

        Random generator = new Random();

        int die1Value;
        int die2Value;
        int count = 0;
        int snakeEyes = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;

        do{
            die1Value = generator.nextInt(6) + 1;
            System.out.println("You rolled: " + die1Value);

            die2Value = generator.nextInt(6) + 1;
            System.out.println("You rolled: " + die2Value);

            if (die1Value == die2Value)
            { 
                if(die1Value == 1)
                {
                    snakeEyes++;
                } 
                else if (die1Value == 2)
                {
                    twos++;
                } 
                else if (die1Value == 3)
                {
                    threes++;
                } 
                else if (die1Value == 4)
                {
                    fours++;
                } 
                else if (die1Value == 5)
                {
                    fives++;
                } 
                else if (die1Value == 6)
                {
                    sixes++;
                }
            }
            count++;
        }while (count < NUMBER);

        System.out.println ("You rolled snake eyes " + snakeEyes +
                " out of " + count + " rolls.");
        System.out.println ("You rolled double twos " + twos +
                " out of " + count + " rolls.");
        System.out.println ("You rolled double threes " + threes +
                " out of " + count + " rolls.");
        System.out.println ("You rolled double fours " + fours +
                " out of " + count + " rolls.");
        System.out.println ("You rolled double fives " + fives +
                " out of " + count + " rolls.");
        System.out.println ("You rolled double sixes " + sixes +
                " out of " + count + " rolls.");
    }
}