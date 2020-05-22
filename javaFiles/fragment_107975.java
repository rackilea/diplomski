public class Prob4 {



public static void main(String[] args) {
 int max = 0;

 for(int i = 100; i< 1000; i++)
{
  for(int j = 100; j < 1000; j++)
 {
  if (palindrome(i * j))
  {
 if((i*j) > max)
 max = i * j;

   }


  }

 }
  System.out.println(max);
  }

  public static boolean  palindrome(int a)
   {
    int acopy = a;
    int rev = 0;
    int rem;
    while(acopy !=0)
   {
    rem = acopy %10;
    rev = rev * 10 + rem;
    acopy = acopy / 10;

   }
   if(rev == a)
    return true;
  else
   return false;
 }

  }