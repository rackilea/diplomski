import java.util.Scanner;
import java.util.Arrays;

public class de
{
  public static void main (String[] args ) {

    Scanner in = new Scanner (System.in);

    int[] counts = new int[1000];
    int[] counts2 = new int[1000];

    int userInput;
    String input;
    int counter = 0;

    userInput = in.nextInt();
    in.nextLine();

    if (userInput == 1){ //used in your previous code
        rollDice(counts,6); //populates array count with Random int by 6
        rollDice(counts2,6); //populates array count with Random int by 6
        counter = compareDoubles(counts,counts2,1);
        System.out.println("is " + counter);
    }

  }
  /*
   * count: Array to store resulting dice rolls
   * diceSize: number of different results from rolling dice
   */
  static void rollDice(int[] counts, int diceSize){
        for (int i = 0; i < counts.length; i++){
            counts [i] = (int)(Math.random ()*diceSize+1); 
        }
  }
  /*
   * firstCounts: first set of numbers
   * secondCounts: second set of numbers
   * num: number to compare both sets against
   * returns number of times both sets evaluate to num
   */
  public static int compareDoubles (int [] firstCounts, int[] secondCounts, int num)  {
    int amount = 0;

    if(firstCounts.length <= secondCounts.length){ //make sure we don't get arrayOutOfBounds
    for(int i = 0; i <firstCounts.length; i++) 
        if (firstCounts[i] == num && secondCounts[i] == num) 
            amount++;
    }
    return amount;
  }  
}