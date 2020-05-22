public class VendingMachineChangeCalculator {

public static void main(String[] args) {    
    // TODO Auto-generated method stub    
Scanner takeit = new Scanner(System.in);
System.out.println("Enter a whole number from 1 to 99"
    + "\nI will find a combination of coins that equals"
    +"the amount of change ");
int money = 0;
System.out.println("Please enter number: ");
money = takeit.nextInt();
takeit.close();
System.out.println("You have: ");
int quarter, dime, nickel, penny;

quarter = money/25
money = money - quarter*25;
dime = money/10;
money = money - dime*10;
nickel = money/5;
money = money - nickel*5;
penny = money;

System.out.println(quarter + " quarters");
System.out.println(dime + " dimes");
System.out.println(nickel + " nickels");
System.out.println(penny + " pennies");


    }

}