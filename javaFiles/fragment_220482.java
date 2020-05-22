static BitSet bs = new BitSet(3);   
static void fill(int k, int n)
{
   if (k == n)
   {
      System.out.println(bs);
      return;
   }
   bs.set(k, false);
   fill(k+1, n);
   bs.set(k, true);
   fill(k+1, n);
}

public static void main(String[] args)
{
    fill(0, 3);
}