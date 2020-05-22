import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String[] args)
       {
          Scanner in=new Scanner(System.in);
          System.out.println("Please enter a sentance to scramble: ");
          String word = in.nextLine();


          //Split your input phrase
          String[] wordsArray = word.split(" ");
          //For each word in the phrase call your scramble function
          // and print the output plus a space
          for (String s : wordsArray){
              System.out.print(scramble(s) + " ");
          }

       }
  public static String scramble (String word) {
    int wordlength = word.length();
    Random r = new Random();
  if (wordlength > 3) {
    int x = (r.nextInt(word.length()-2) + 1);
   int y;
   do {
    y = (r.nextInt(word.length()-2) + 1); 
   } while (x == y);
   char [] arr = word.toCharArray();
   arr[x] = arr[y];
   arr[y] = word.charAt(x);
   return word.valueOf(arr);
  }
  else {
    return word;
  }
  }
}