import java.util.Scanner;
import java.util.ArrayList;

public class Groceries {

  static Scanner scan = new Scanner(System.in);
  static ArrayList<String> shoppingList = new ArrayList<>();
  static int b = 0;

  public static void main(String[] args) {
    getAmount();
    getInput();
    output();
  }

  private static void getAmount() {
    System.out.println("How many articles do you want to buy?");
    b = scan.nextInt();
    System.out.println(b);
    scan.nextLine(); // this is required
  }

  private static void getInput() {
    System.out.println("Which articles specifically do you want to buy?");
    for (int i = 0; i < b; i++) { // bug fixed
      String n = scan.nextLine();
      shoppingList.add(n);
    }
  }

  private static void output (){
    System.out.println("Here are your purchases:");
    for (int i = 0; i< shoppingList.size(); i++){
      System.out.println (shoppingList.get(i) );
    }
  }

}