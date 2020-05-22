public static void random3()
{
    int a = (int)(Math.random() * 1000);
    int b = (int)(Math.random() * 1000);
    int c = (int)(Math.random() * 1000);
    System.out.println("a = " + a + ", b = " + b + ", c = " + c);

    return new int[]{a, b, c};
}