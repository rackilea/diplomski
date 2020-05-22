import java.util.Scanner;

public class valin {

  public static void main(String[] args)
  {
    Integer inputNumber = -1;

    Scanner in = new Scanner(System.in);

    System.out.println("Enter a number between 5 and 10: ");

    while(in.hasNextLine()){
      String line = in.nextLine().trim();

      try{
        inputNumber = Integer.parseInt(line);
      }catch (NumberFormatException nfe){
        System.out.println("That is not a number. Please try again.");
        continue;
      }

      if(inputNumber >= 5 && inputNumber <= 10){
        System.out.println("You entered: " + inputNumber);
        break;
      }else{
        System.out.println("That is not a number between 5 and 10. Please try again.");
      }
    }

    in.close();

  }

}