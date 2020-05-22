import java.util.Scanner;

public class PermuteCharacters
{
   public static void main(String[] args)
 {
       Scanner in = new Scanner(System.in);

  System.out.println("Enter a word to permute: ");

  String word = in.next();
  for (int n = 0; n < word.length(); n++)
  {
     /** 
        The -1 here guarantees that later we won't pick a j that goes off
        the end of the string. This is important since since the 
        pseudocode tells us to pick a j > i
     */
     int i = (int) (Math.random() * word.length() - 1);
     int j = (int) (Math.random() * (word.length() - i - 1)) + i + 1;

     String first = word.substring(0, i);
     String middle = word.substring(i + 1, j);
     String last = word.substring(j + 1);

     word = first + word.charAt(j) + middle + word.charAt(i) + last;
  }

  System.out.println("Your permuted word is: " + word);
   }
}