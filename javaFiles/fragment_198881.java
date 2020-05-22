package my.proj.sims;

public class DiceRoller
{ 
    public DiceRoller ()
    {
    }

    // Rolls and prints the result of 'n' number of rolls
    public void rollAndShow(int n)
    {
        Dice dice = new Dice();

        for (int i = 0; i < n; i++)
        {
            System.out.println(dice.roll()); // You should never use S.o.p in a method - it's bad practice, but it's easier this way if you don't yet understand the concept of objects
        }
    }
}