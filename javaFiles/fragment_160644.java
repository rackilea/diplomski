class Test
{
    public static void main (String[] args)
    {
        int x;                        // x has no value

        for (int i = 0; i < 0; i++)   // Bogus bounds -> never enters loop.
        {
            x = 3;                    // Never happens
            System.out.println("in loop : " + x);
        }

        System.out.println("out of loop " + x); // x has no value here!!
    }
}