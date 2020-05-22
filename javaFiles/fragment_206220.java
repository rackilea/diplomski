printStar(int x)
{
   if(x > 0)
   {
     System.out.print("*");
     printStar(x-1);
   }
}