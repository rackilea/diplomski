import java.util.Scanner;
import java.util.Arrays;

public class Assignment3 {
public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);

    System.out.println("Your favorite movies:");
    System.out.println("How many favorite movies do you have?");

    String numberResponsesStr = userInput.nextLine();
    int numberResponses;
    try {
        numberResponses = Integer.parseInt(numberResponsesStr);
    } catch (Exception e) {
        System.out.println("Invalid input. Please enter a number.");
        return;
    }

    if (numberResponses < 1) {
        System.out.println("Invalid input. Please enter a positive number.");
        return;
    }

    String[] theUltimateArray = new String[numberResponses]; //just like you thought
    for (int i = 0; i < numberResponses; i++) {
        theUltimateArray[i] = "ZZZ"; //start ZZZ, not null, to avoid ugliness and bad sorts, and so these are at the end with this sentinel value
    }

    System.out.printf("List your %d favorite movies. Separate them with commas (Movie1, Movie2, Movie3, etc.).", numberResponses);
    String favMovies = userInput.nextLine();
    System.out.println();
    String[] favMoviesArray = favMovies.split("\\s*,\\s*");
    //Arrays.sort(favMoviesArray); don't sort yet, want the first ones entered, not first alphabetically

    System.out.printf("Your %d favorite movies are: %n", numberResponses);
    //System.out.println(Arrays.toString(favMoviesArray));

    int n = Math.min(numberResponses, favMoviesArray.length); //number we can copy
    for (int i = 0; i < n; i++) { //copy
        theUltimateArray[i] = favMoviesArray[i];
    }
    Arrays.sort(theUltimateArray);
    System.out.println(Arrays.toString(theUltimateArray)); //never larger than they said. Filled at end

    userInput.close();
}

}