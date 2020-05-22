import java.util.Arrays;
import java.util.Scanner;


public class squareAgain {

static Scanner scan =  new Scanner(System.in);
static int[][] userSquare = new int[0][0];
static int[] mathLRTotals = new int[0], mathTBTotals = new int[0], mathDLRTotals = new int[1], mathDRLTotals = new int[1];
static String userMenuInput = "presetByProgrammer";
static int totalElements = 0;

public static void main(String[] args) {
    while(userMenuInput != "quit"){

        mainMenu();
        System.out.print("Your Choice: ");
        userMenuInput = scan.next();

        switch(userMenuInput.toLowerCase()){
        case "rules": 
            menuOptionRules();
            break;
        case "play": 
            menuOptionPlay(); 
            break;
        case "quit":
            System.out.println("Now Quitting.");
            userMenuInput = "quit";
            break;
        default: 
            System.out.println("You Typed something wrong."); 
            break;
            }

    }
}
private static void mainMenu(){
    System.out.println(" Welcome to Magic Square! ");
    System.out.println("--------------------------");
    System.out.println("Type any of the following:");
    System.out.println("--------------------------");
    System.out.println("Rules     (Displays Rules)");
    System.out.println("Play     (Starts The Game)");
    System.out.println("Quit      (Quits The Game)");
    System.out.println("--------------------------");
}
private static void menuOptionRules(){
    System.out.println("The Rules Are: ");
    System.out.println("1: All numbers must be different");
    System.out.println("       It will tell you if you have duplicates.");
    System.out.println("2: All numbers must add up to be the same Left to right");
    System.out.println("3: All numbers must add up to be the same Top to Bottom");
    System.out.println("4: All numbers must add up to be the same Diagonal Top left to Bottom Right");
    System.out.println("4.A: All numbers must add up to be the same Diagonal Top Right to Bottom Left");
}
private static void menuOptionPlay(){
    getUserInputs();
    mathLR();
    mathTB();
    mathDLR();
    mathDRL();
    outputs();  
}
private static void getUserInputs(){

    System.out.println("Thank You For Playing.");
    System.out.print("Please Enter A Size For Your Square: ");
    int userSquareSizeInput = scan.nextInt();
    userSquare = new int[userSquare.length+userSquareSizeInput][userSquare.length+userSquareSizeInput];
    System.out.println("Array Length is now: " + userSquare.length);
    totalElements = userSquareSizeInput * userSquareSizeInput;
    System.out.println("This Means You Will Have " + totalElements + " elements." );
    System.out.println();

    int tempForGridInputRow = 0, tempForGridInputCol = 0;
    for(int temp = 0; temp != totalElements; temp++){
        if(tempForGridInputCol == userSquare.length){tempForGridInputRow++; tempForGridInputCol = 0;}
        System.out.print("Please Eneter A number for Grid Position: " + tempForGridInputRow + " , " + tempForGridInputCol + ": ");
        userSquare[tempForGridInputRow][tempForGridInputCol] = scan.nextInt();
        tempForGridInputCol++;
    }
    System.out.println();
}
private static void mathLR(){
    mathLRTotals = new int[mathLRTotals.length+userSquare.length];

    int tempForGridInputRow = 0, tempForGridInputCol = 0, tempElement = 0, tempTotal = 0;
    for(int temp = 0; temp < totalElements; temp++){
        tempElement = tempElement + userSquare[tempForGridInputRow][tempForGridInputCol];
        tempTotal = tempElement;
        tempForGridInputCol++;

        if(tempForGridInputCol == userSquare.length){
            mathLRTotals[tempForGridInputRow] = tempTotal; 
            tempForGridInputRow++; 
            tempForGridInputCol = 0;
            tempTotal = 0;
            tempElement = 0;
            }
    }
}
private static void mathTB(){
    mathTBTotals = new int[mathTBTotals.length+userSquare.length];

    int tempForGridInputRow = 0, tempForGridInputCol = 0, tempElement = 0, tempTotal = 0;
    for(int temp = 0; temp < totalElements; temp++){            
        tempElement = tempElement + userSquare[tempForGridInputRow][tempForGridInputCol];
        tempTotal = tempElement;
        tempForGridInputRow++;
        if(tempForGridInputRow == userSquare.length){
            mathTBTotals[tempForGridInputCol] = tempTotal; 
            tempForGridInputRow = 0; 
            tempForGridInputCol++;
            tempTotal = 0;
            tempElement = 0;
            }
    }
}
private static void mathDLR(){
    int tempElement = 0;

    for(int temp = 0; temp != userSquare.length; temp ++){

        tempElement = tempElement + userSquare[temp][temp];
        mathDLRTotals[0] = tempElement;
    }
}
private static void mathDRL(){
    int tempForGridInputRow = 0, tempForGridInputCol = userSquare.length-1, tempElement = 0;

    for(int temp = 0; temp != userSquare.length; temp ++){

        tempElement = tempElement + userSquare[tempForGridInputRow][tempForGridInputCol];
        mathDRLTotals[0] = tempElement;

        tempForGridInputRow++;
        tempForGridInputCol--;
    }
}
private static void outputs(){
    System.out.println("You Entered " + userSquare.length + " As your grid length and height");
    System.out.println("This means there was " + totalElements + " elements in your square.");
    System.out.println("Here is what you entered: ");
    System.out.println(Arrays.deepToString(userSquare));
    System.out.println("The totals for each row are: ");
    System.out.println(Arrays.toString(mathLRTotals));
    System.out.println("The totals for each column are: ");
    System.out.println(Arrays.toString(mathTBTotals));
    System.out.println("The total of the Left to Right Diagonal: ");
    System.out.println(Arrays.toString(mathDLRTotals));
    System.out.println("The total of Right to Left Diagonal: ");
    System.out.println(Arrays.toString(mathDRLTotals));
    System.out.println();

    String tempYesForLR = "setByProgrammer";
    int tempCompareLR = mathLRTotals[0];
    for(int temp = 0; temp != mathLRTotals.length; temp++){
        if(tempCompareLR == mathLRTotals[temp]){tempYesForLR = "true";}else{tempYesForLR = "false"; break;}
    }

    String tempYesForTB = "setByProgrammer";
    int tempCompareTB = mathTBTotals[0];
    for(int temp = 0; temp != mathTBTotals.length; temp++){
        if(tempCompareTB == mathTBTotals[temp]){tempYesForTB = "true";}else{tempYesForTB = "false"; break;}
    }

    Boolean tempForYesDag = false;
    if(mathDLRTotals[0] == mathDRLTotals[0]){tempForYesDag = true;}

    if(tempYesForLR == tempYesForTB == tempForYesDag){
        System.out.println("All of the rows added up to be: " + mathLRTotals[0]);
        System.out.println("You created a Perfect Square!");
        System.out.println();
        }
    else{
        System.out.println("Your rows didn't add up to the same number.");
        System.out.println("Review what you entered and try again!");
        System.out.println();
    }
}