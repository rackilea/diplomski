public static int findEscapeCount(double x, double y, int maxIterations)
{
   int count =0;
   double a;
   double b;
   double newA;
   double newB;


   while((a * a + b * b) > 4)
   {
      a++;
      b++;

      newA = a * a - b * b + x;
      newB = 2 * a * b + y;
      a = newA;
      b = newB;

      count++;

   }

   return count;

}