public static boolean checkPrime(int num)
{
   if(num<2)
     return false;
   else
     return checkPrime(num, 2);
}