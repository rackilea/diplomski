static int len=3;
  public static int backwards(int copy)
  {
    if(copy==0)
    {
      return 0;
    }
    return  (int)Math.pow(10, len--)*(copy%10) + backwards(copy/10);
  }