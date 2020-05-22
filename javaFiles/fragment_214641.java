public static void method_c(int n) 
{
    if (n > 0)
    {
        System.out.print(n % 10);
        n /= 10;
        method_c(n);
    }
}