import java.util.ArrayList;
import java.util.Scanner;

public class ReadNumbers {
  public static void main(String[] args) {
    ArrayList<Integer> inputs = new ArrayList<Integer>();
    System.out.println("Enter some numbers: ");
    try (Scanner scnr = new Scanner(System.in)) {
      do {
        inputs.add(scnr.nextInt());
        System.out.println("Would you like to enter another y/n?");
      } while (scnr.next().equalsIgnoreCase("y"));
    }
    System.out.println(inputs);
  }
}