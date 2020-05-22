public class Palindrome
{
    public static boolean isPalindrome(String input)
     {

         char[] inputArray = input.toCharArray();
         bool isOk = true;
         for(int i = 0; i < inputArray.length/2 && isOk; i++){
             isOk &= inputArray[i] == inputArray[inputArray.length - i - 1];
         }
         return isOk;
     } // end method
} //end class Palindrome