import java.util.Scanner;
import java.util.Arrays;

/**
 * Word Manager
 *
 * @author Harry
 */
public class WordManager {

/**
 * Adds the word to the next empty space in the array, if there is space.
 * Returns the new size of the array.
 */

public static int add(String[] words, int count, String word) {
    if (count < words.length) {
        words[count] = word;
        count++;
    } else {
        System.out.println("The array is full");
    }
    return count;
}

/**
 * Displays the words in the collection as a comma separated list.
 */
public static void printList(String[] words, int count) {
}


private static void averageLength(String[] words, int count) {
    int sum=0;

    for(int word =0; word < count; word++){
     int wordLength = words[word].length();
     sum += wordLength;
    }

    double averageWorldLength = sum/count;
    System.out.println("Average word length = " +averageWorldLength;
}


public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] words = new String[20];
    int count = 0;
    String aWord;
    int choice;

    do {
        displayMenuOptions();
        choice = sc.nextInt();
        System.out.println("choice = " + choice);

        switch (choice) {
            case 1:
                System.out.println("Add a word");
                aWord = sc.next();
                count = add(words, count, aWord);
                break;

            case 2:
                System.out.println("Display words");
                System.out.println("We have an array of " + words.length + " integers: " + Arrays.toString(words));
                break;

            case 3:
                  averageLength(words, count);
                  break;
            default:
                System.out.println("Invalid responce");

        }
    } while (choice >= 0 && choice < 4);
}

private static void displayMenuOptions() {
    System.out.println("\t MENU:");
    System.out.println("1. Add a word");
    System.out.println("2. Display words:");
    System.out.println("3. Display average word length");
    System.out.println("4. Quit");
    System.out.println("Enter option: ");
 }
}