import java.text.NumberFormat;
import java.util.Scanner;

public class JavaApplication7 {

public static void main(String[] args) {
System.out.println("Please enter the number of test scores to be entered");
System.out.println("To end the program enter 999.");
System.out.println();  // print a blank line
int scoreCount = 0,scoreTotal = 0;
int testScore = 0;
int min = 100;
int max = 0;
int counter = 0;
int setNumber = 0;
String userAnswer = "n";
Scanner sc = new Scanner(System.in);
// get a series of test scores from the user
do {
    // user enters number of test scores to be entered
    System.out.print("Enter the number of test scores to be entered: ");
    setNumber = sc.nextInt();
    if (setNumber > 0 && setNumber != 999)
    {
        scoreCount=0;
             scoreTotal=0;
        while (setNumber > 0)
        {
        // user enters test scores   
        System.out.print("Enter score: ");
        testScore = sc.nextInt();
            if (testScore <= 100)
            {      
                scoreCount += 1;
                scoreTotal += testScore;
                setNumber --;
            } //Added for Exercise 2-2, #4 modified if statement
            else if (testScore > 100 || testScore < 0) {
                System.out.println("Invalid entry, score not counted");
            } else if (testScore == 999) {
                System.out.println("Average test score complete");
            }
            if (testScore > max && testScore <= 100) {
                max = testScore;
            }
            if (testScore < min && testScore >= 0) {
                min = testScore;
            }
        }
       // display the score count, score total, and average score
// Added casting from int ot double Exercise 3-2 #5
 double averageScore = (double) scoreTotal / (double) scoreCount;
 // Added number formatting ( 1 decimal place) 
NumberFormat number = NumberFormat.getNumberInstance();
number.setMaximumFractionDigits(1);
String message = "\n"
        + "Score count:   " + scoreCount + "\n"
        + "Score total:   " + scoreTotal + "\n"
        + "Average score: " + averageScore + "\n"
        //Added for Exercise 3-2 #4 add min/max
        + "Max score: " + max + "\n"
        + "Min score: " + min + "\n";
System.out.println(message); 
    }
    System.out.print("Enter more test scores? (y/n): ");
    userAnswer=sc.next();     // Single Error----Only corrected piece of code.
    }while(userAnswer.compareTo("y") == 0 );    
// end of do loop
}