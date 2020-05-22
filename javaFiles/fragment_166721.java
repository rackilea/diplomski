import java.util.*;

public class CharCount {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        //Prompt for user entry
        System.out.println("Enter a phrase: ");
        String letterN = keyboard.nextLine();

        charCount(letterN);
    }


    public static void charCount(String letterN) {
        Map<Character, Long> charMap = new TreeMap<>();
        for (char aChar : letterN.toCharArray()) {
            if (charMap.containsKey(aChar)) {
                charMap.put(aChar, charMap.get(aChar) + 1);
            }
            else {
                charMap.put(aChar, 1L);
            }
            // this if/else can be written using the ternary operator as:
            // charMap.put(aChar, charMap.containsKey(aChar) ? charMap.get(aChar) + 1 : 1L);
        }
        for (Character character : charMap.keySet()) {
            System.out.println(character + ": " + charMap.get(character));
        }
    }
}