public class arrayTest
{
   public static void main(String [] args)
   {
      int[] arrayA = {2,4,8,19,32,17,17,18,25,17};
      int varB = 17;
      // Call with the array and variable you need to find.
      newSmallerArray(arrayA, varB);
   }

   public static void newSmallerArray( int[] arrayA, int varB)
   {
      for(int B = 0; B < arrayA.length; B++)
      {
         if(arrayA[B] != varB)
         {
            System.out.print(arrayA[B] + " ");
         }
      }
   }
}