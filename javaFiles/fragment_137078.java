public class Main 
 {
 public static void main (String[]args)
 {
  int fact = 1;
  int sum = 0;
  int i, j = 1;
  for (i = 1; i <= 20; i++)
  {
    for (j = 1; j <= i; j++)
    {
      fact = fact * j;
  }
  sum += fact;
  System.out.println ("sum = " + sum);
  fact = 1;
  }
 }
}