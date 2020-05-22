import java.util.Scanner;

public class AtmMachine {

public static void main(String[] args){

    int actualPin = -1;
    int sel = 0, pin, pin2, check, ctr = 0, dep, with, bal = 10000;
    Scanner sc = new Scanner(System.in);

    while(actualPin == -1)
    {
    System.out.print("Please enter a new pin: ");
    pin = sc.nextInt();

    System.out.print("Please verify your new pin: ");
    pin2 = sc.nextInt();
    if(pin == pin2) actualPin = pin;
    else System.out.println("Error");
    }

    boolean logged = false;

    while (true){

    if(logged){
    System.out.println("What would you like to do?");
    System.out.println("1 - Check Balance");
    System.out.println("2 - Deposite");
    System.out.println("3 - Withdraw");
    System.out.println("4 - Change Pin");
    System.out.println("5 - End Transaction");
    sel = sc.nextInt();
    switch (sel){
        case 1: 
            System.out.println("Your current balance is "+ bal);
            break;
        case 2:
            System.out.println("How much would you want to deposite? ");
            dep = sc.nextInt();
            bal= dep+bal;
            System.out.println("Your new current balance is "+ bal);
            break;
        case 3:
            System.out.println("How much would you want to Withdraw? ");
            with = sc.nextInt();

            if(with > bal){
            System.out.println("You do not have that amount on your account! Please enter again.");
            }
            else{
            System.out.println("You withdrew "+ with);
            bal = bal-with;
            System.out.println("Your new current balance is "+ (bal));
            }
            break;
        case 4:
            System.out.print("Please enter a new pin: ");
            pin = sc.nextInt();

            System.out.println("Please verify your new pin: ");
            pin2 = sc.nextInt();
            if(pin == pin2) actualPin = pin;
            else System.out.println("Error");
            break;
        case 5:
            logged = false;
            break;
        default:
            break;
    }
    else{
        System.out.println("Please Enter Pin: ");
        sel = sc.nextInt();
        logged = actualPin == sel;
    }
    }
    }
}