public static int exponent(int a,int b)
{
  int c = a;
  int count;
  Scanner keyboard = new Scanner(System.in);

  for(count = 1; count < b; count = count + 1, c = c * a)
  {
  System.out.println(count);

  }

return c;
}