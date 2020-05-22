public class Example1 {

public static int[] getPositiveNumbes(int[] numbers)
{
    int total = 0;
    for (int i = 0; i < numbers.length; i +=1)
    {
        if (numbers[i] > 0)
        {
            total += 1;
        }
     }
     int[] nums = new int[total];
     int j = 0;
     for ( int i = 0; i < numbers.length; i+= 1)
     {
         if (numbers[i] > 0)
         {
             num[j] = number[i];
             j++;
         }
     }
     return nums;
 }