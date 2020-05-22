import java.util.*;

class Main {
  public static void main(String[] args) {

    Scanner enter = new Scanner (System.in);

    int choice_user = 0; 
    int number_to_search = 5; 
    int choice_user_number = 0;
    int number_attempt = 1;

    do{

      System.out.println("********Menu*******");
      System.out.println("1) - Start the game :");
      System.out.println("2) - Exit the game :");

      System.out.print("Entrer your choice : ");
      choice_user = enter.nextInt();

      switch(choice_user){

        case 1: 
          System.out.println("Option 1 : ");
          number_attempt = 1; // set fo first attempt
          while(number_attempt <= 5){ // only has 5 attempts
            System.out.print("Enter your number : ");
            choice_user_number = enter.nextInt();

            if(choice_user_number > number_to_search){
              System.out.println("Smaller ! Attempt : " + number_attempt);
            }
            else if(choice_user_number < number_to_search){
              System.out.println("Bigger ! Attempt : " + number_attempt);
            }

            else{
              System.out.println("Bravo ! Attempt : " + number_attempt);
              number_attempt = 6; // force to exit the loop
            }

            number_attempt++;
          }
        break; 

        default:
          System.out.print("Exit... ");

      }

    } while(choice_user != 2);
  }
}