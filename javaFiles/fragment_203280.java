import java.util.Scanner;

public class PigLatin
{
   public static void main(String[] args)
   {
      System.out.print("Enter a line of text: ");
      Scanner keyboard = new Scanner(System.in);
      String text = keyboard.nextLine();

      System.out.println("\nInput: " + text);
      System.out.print("Output: ");

      if (text != null && text.length() > 0)
      {
         int i = 0;
         // this iterates through the whole string, stopping at a period or
         // the end of the string, whichever is closer
         while (i < text.length() && text.charAt(i) != '.')
         {
            // these three variables only exist in this code block,
            // so they will be re-initialized to these values
            // each time this while loop is executed
            char first = '\0'; // don't worry about this, I just use this value as a default initializer
            boolean isFirst = true;
            boolean firstIsVowel = false;
            // each iteration of this while loop should be a word, since it 
            // stops iterating when a space is encountered
            while (i < text.length()
                   && text.charAt(i) != ' '
                   && text.charAt(i) != '.')
            {
               // this is the first letter in this word
               if (isFirst)
               {
                  first = text.charAt(i);
                  // deal with words starting in vowels
                  if (first == 'a' || first == 'A' || first == 'e' || first == 'E'
                      || first == 'i' || first == 'I' || first == 'o' || first == 'O'
                      || first == 'u' || first == 'U')
                  {
                     System.out.print(first);
                     firstIsVowel = true;
                  }
                  // make sure we don't read another character as the first 
                  // character in this word
                  isFirst = false;
               }
               else
               {
                  System.out.print(text.charAt(i));
               }

               i++;
            }

            if (firstIsVowel)
            {
               System.out.print("-tay ");
            }
            else if (first != '\0')
            {
               System.out.print("-" + first + "ay ");
            }

            i++;
         }

         System.out.print('\n'); //for clean otuput
      }
   }
}