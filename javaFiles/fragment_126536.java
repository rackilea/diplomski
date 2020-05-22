import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    public class WaitTest {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
              String user;
              int charCount;
              List<Character> vowels = new ArrayList();
              //add all vowels to list inclusing uppercase 
 a,e,i,o,u,A,E,I,O,U
              vowels.add('a');
              vowels.add('e');

              List<Character> wordSeperators = new ArrayList();
              //add your word seperators here
              wordSeperators.add(' ');
              wordSeperators.add(',');

              System.out.println("Please enter any string!");
              user = input.nextLine();
              charCount = user.length();
               int vowelCount=0,wordCount=0;
              for (int i = 0; i < charCount; i++) {
                 char c= user.charAt(i);
                 if(vowels.contains(c)) {
                     vowelCount++;
                 }else if (wordSeperators.contains(c)){
                     wordCount++;
                 }
              }
            }
    }