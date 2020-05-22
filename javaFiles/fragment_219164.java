import java.util.Scanner;

class Bigger {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // get user name from the user
    System.out.print("Please enter your user name: ");
    String userName = input.nextLine();
    // get second name from the user
    System.out.print("Please enter your second name: ");
    String secondName = input.nextLine();

    // use an appropriate method to find the number of letters and prompt user
    if(userName.length() == secondName.length()) {
      System.out.println(userName + " is equal in length than " + secondName);
    } else if(userName.length() > secondName.length()) {
      System.out.println(userName + " is longer in length than " + secondName);
    } else {
      System.out.println(userName + " is shorter in length than " + secondName);
    }
  }
}