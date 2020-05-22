public static void printNum(int a)
{
    System.out.println("Before recursion: " + a);
    if(a <= 3)
    {
        System.out.println("Recursing");
        printNum(a + 1);
    }
    System.out.println("After recursion: " + a);
}