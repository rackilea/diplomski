public class Test
{
    public static void main(String[] args)
    {
        int a = 5;
        if(a > 2 && (a < 6 || a < 4))
            System.out.println(true);
        else
            System.out.println(false);
    }
}