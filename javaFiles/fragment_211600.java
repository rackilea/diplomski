class Main
{
    public static void main (String[] args)
    {
        for(int i = 0 ; i < 20 ; i++)
        {
            int a = (i / 6) * 7 + 2 + ((i / 3) & 1) * 3;
            int b = (i % 3) * 2 + 1;
            System.out.println(i + " | " + a + " | " + b);
        }
    }
}