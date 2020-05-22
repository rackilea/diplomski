import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaApplication20 {

   public static void main(String [] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a sentence:\t");
    String sentence = scanner.nextLine();
    System.out.print("Enter a word:\t");
    String word = scanner.nextLine();

    Pattern p = Pattern.compile(word);
    Matcher m = p.matcher(sentence);
    int count = 0;
    while (m.find()){
        count +=1;
    }    
    System.out.println("in your sentence the frequency of \""+word+"\" is:\t" + count);      
   }    
}