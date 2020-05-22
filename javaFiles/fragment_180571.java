import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence;
        System.out.println(" Please enter senctence with space: ");
        sentence = sc.nextLine();
        String words[] = sentence.split(" ");
        String mostconstword = null;
        char[] constants = {'b', 'c', 'd', 'f', 'g', 'j', 'h', 'q', 'x', 'z', 'l', 'm', 'p', 's', 'r', 'n', 't'};

        int maxconsonant = 0;        

        //Each word splited
        for (String word : words) {
            int consonantInWord = 0;
            word = word.toLowerCase();
            //Each char in the current word
            for (int i = 0; i < word.length(); i++) {
                char wr = word.charAt(i);
                //Verify if consonant
                for (char constant : constants) {
                    if(wr == constant){
                        consonantInWord++;
                        break;
                    }
                }                
            }
            //verify if maxconsonant
            if(maxconsonant < consonantInWord){
                mostconstword = word;
                maxconsonant = consonantInWord;
            }
        }
        System.out.println("most constant word = " + mostconstword + " sum of constants in this word =" + maxconsonant);
    }

}