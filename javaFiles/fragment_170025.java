import java.util.Scanner;

public class MeowSample{
    public static void main(String[] args) {

    Scanner okay = new Scanner(System.in);
    System.out.println("Please enter a letter ");
    char letter = okay.next().charAt(0);
    //if(letter != 'x' || letter != 'y' || letter != 'z' || letter != 'q'){
    //    System.out.println("Errorrr");
    //}
    if(letter == 'x' || letter == 'y' || letter == 'z'|| letter == 'q'){ // this one is OK
        System.out.println("Correct!");
    } else { // <-- add the else
        System.out.println("Errorrr");  // Move the error print down here.
    }
}