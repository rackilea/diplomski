import java.util.Scanner;

public class Palindrome { //<-- added public to the class otherwise main method won't be called

public static boolean isPalindrome(String word) { //<--changed the String[] to String
    for (int i = 0; i < word.length(); i++) {
        if (!(word.charAt(i) == word.charAt(word.length() - 1 - i))) { //Since [] will not work on Strings, using charAt() to do the same thing
            return false;
        }
    }
    return true;
}

// read word
public static String readWord(Scanner input) {
    String word = input.nextLine();
    word = word.toLowerCase();
    return word;
}

// display results to the screen
public static void displayResults(boolean result) {
    // display the results
    String msg = "\nThat string ";
    msg += (result == true) ? " IS " : " is NOT ";
    msg += " a palindrome.\n";
    System.out.println(msg);
}

// main function
public static void main(String[] args) {
    // input scanner
    System.out.print('\u000C');
    System.out.println("Enter the word: ");
    String s = readWord(new Scanner(System.in)); //Added a call to the readWord method and also passed a Scanner reference to the method and 
                                                 //storing the read word in String s
    boolean result = isPalindrome(s); //Added a call to the palindrome method and also passing the read string s to the method to find whether
                                      //it is palindrome or not and storing the method return value in boolean result variable
    displayResults(result); //Finally calling the displayResults with the result we got from isPalindrome() to display the appropriate message
}
}