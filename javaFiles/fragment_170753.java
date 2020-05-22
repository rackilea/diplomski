static void test(int i)
{
   if (i == 0) return;
   test(i-1);
}

public static void main(String[] args)
{
   test(10000);
}