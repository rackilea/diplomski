import java.util.Scanner;

public class BillingSystem {

 public static void main(String[] args) {
    // declare variables

    String name,addr;
    int pread, cread,tel; //New variables here

    // input

    Scanner input = new Scanner (System.in);
    System.out.println("Enter The Customer Name");
    name= input.nextLine();

    //Scanner address = new Scanner (System.in); no need for this
    System.out.println("Address of The Customer");
    addr= input.nextLine();

    //Scanner telephone = new Scanner (System.in); no need for this
    System.out.println("Enter telephone number");
    tel=input.nextInt(); //get integer input and store it in tel

    System.out.println("Enter Previous reading");
    pread=input.nextInt(); //get integer input and store it in pread

    System.out.println("Enter Current reading");
    cread=input.nextInt(); //get integer input and store it in cread



 }
}