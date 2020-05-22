import java.util.Scanner;

public class Test {

    static boolean isVowel(char v) {
         if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u') {
             return true;
         }
         return false;
    }
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("type in a phrase you would like to convert to Ubbi Dubbi");

        String phrase = scan.nextLine();
        StringBuilder result = new StringBuilder();
        boolean prevVowel = false; //is our vowel part of a cluster?

        for (int i = 0; i < phrase.length(); i++) {
        if (isVowel(phrase.charAt(i))) {
            if(prevVowel==false)
                result.append("ub");

            prevVowel=true;
        }
        else
            prevVowel=false;
        result.append(phrase.charAt(i)); //should be added anyway

        }
        System.out.println(result);    

    }
}