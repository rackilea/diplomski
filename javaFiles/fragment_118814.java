public class Dice{
    private final int numSides;

    public Dice (int sides)
    {
        this.numSides = sides;

    }
    public int roll(int times)
    {
        int sum=0;
        Random dice = new Random();
        for(int i=0; i<times; i++)
        {
            sum += dice.nextInt(numSides) + 1;
        }
        return sum;
    }

   }