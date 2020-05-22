import java.util.Scanner;

public class Question2 {
  public static void main(String args[]) {
    Scanner userinput = new Scanner(System.in);

    String ticket ;
    System.out.print(" Type of Ticket: ");
    ticket = userinput.next();

    String discount; 
    System.out.print("What sort of discount do you have?");
    discount = userinput.next();

    int standard = 40;
    int restricted = 20;
    int VIP = 60;

    if ((ticket.equals("standard")) && (type.equals("student"))) {
      double standard_student = standard * 0.95;
    }

    if ((ticket.equals("standard")) && (type.equals("pensioners"))) {
      double standard_pensioners = standard * 0.90;
    }

    if ((ticket.equals("restricted")) && (type.equals("student"))) {
      double restricted_students = restricted * 0.95;
    }


    if ((ticket.equals("restricted")) && (type.equals("pensioner"))) {
      double restricted_pensioner = restricted * 0.90;
    }

    if (ticket.equals("standard"))
      System.out.print("Your ticket costs $.");

    if (ticket.equals("restricted"))
      System.out.print("Your ticket costs $.");

    if (ticket.equals("VIP"))
      System.out.print("Your discount type cannot be used with your requested ticket type.");

    System.out.println ("Thank you!");
  }
} // <--- Add this