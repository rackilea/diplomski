public class PositiveIntegers
{
   public static void main(String[] args)
   { 

   StdOut.println("Enter your integers:");

   int max = Integer.MIN_VALUE;
   int min = Integer.MAX_VALUE;

   while (!StdIn.isEmpty()) {

      int value = StdIn.readInt();

      // Adding the if-statement here to check if number is negative.
      if(value < 0){
         StdOut.println("You entered negative number, try positive numbers.");
         // just reset the max and min variables..
         max = Integer.MIN_VALUE;
         min = Integer.MAX_VALUE;
         continue;
      }

      if (value > max) max = value;
      if (value < min) min = value; 
   }

   StdOut.println("Maximum = " + max + ", Minimum = " + min);

   }
}