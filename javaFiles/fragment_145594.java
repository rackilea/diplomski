import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int between = 100;
    int secretNumber = (int)(Math.random() * between);
    int guesses = 0;

    System.out.println("Lec's Guessing Game");
    System.out.println("====================");
    System.out.print("Please enter a guess between 1 and " + between + "(inclusive):");

    while(scanner.hasNext()){
      if(scanner.hasNextInt()){
        int inputNum = scanner.nextInt();
        guesses++;
        if(inputNum == secretNumber) {
          System.out.println("\nWell done! The secret number was " + secretNumber + "." + "\nYou took " + guesses +  " guesses.");
        }
        // number too high or too low
        if (inputNum > between || inputNum < 1) {
            System.out.println("Out of Range!");
            System.out.print("Enter a guess between 1 and " + between + "(inclusive):");
        }
        // less than secretNumber
        if (inputNum < secretNumber) {
            System.out.println("Too Low...Try Again!");
            System.out.print("Enter a guess between 1 and " + between + "(inclusive):");
        }
        // greater than secretNumber
        if (inputNum > secretNumber) {
          System.out.println("Too High...Try Again!");
          System.out.print("Enter a guess between 1 and " + between + "(inclusive):");
        }
      } else{
        System.out.print("ERROR: Invalid Input");
        System.out.print("Please enter a number: ");
        scanner.next();
      }
    }
  }
}