public class RandomGenerator 
{
    public static void main (String [] args)
    {
        Random generator = new Random ();
        for (int i = 0; i < 2; i++)
        {
            int r = generator.nextInt (2);
        }
    }
}