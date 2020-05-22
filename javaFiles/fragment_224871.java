public void foo( double[] inatt, double[] outatt, double step, int d) 
{
   if( d == inatt.length )
   {
       System.out.println(Arrays.toString(outatt));
   }
   else
   {
      outatt[d] = inatt[d]+step;
      foo( inatt, outatt, step, d+1);
      outatt[d] = inatt[d]-step;
      foo( inatt, outatt, step, d+1);
   }
}