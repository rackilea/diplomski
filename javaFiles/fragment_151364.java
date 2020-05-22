public class SplitTest
{
    public static void main (final String[] args)
    {
        try (Scanner in = new Scanner (System.in))
        {
            while (in.hasNext ())
            {
                System.out.println ("Part 1: " + in.nextDouble ());
                if (in.hasNext ())
                    System.out.println ("Part 2: " + in.nextDouble ());
            }
        }
        catch (final Throwable t)
        {
            t.printStackTrace ();
        }
    }
}