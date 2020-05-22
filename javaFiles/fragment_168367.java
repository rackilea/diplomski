public static int SumUntilBigger(int[] a)
{
   int sum=0;
   for(int i=1;i<a.length;i++)
   {
      if(a[i]<=a[0])
         sum+=a[0]-a[i];
      else
         return sum;            
   }
   return sum;//will reach this statement if all the elements are bigger than the first one
}