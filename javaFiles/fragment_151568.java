//part of your original code
input = new Scanner(System.in);
System.out.println("What's your name?");
String a = input.nextLine();
System.out.println("Welcome to Denny's Market, " + a + "! We have the following items for sale:");
System.out.println("T-shirt     $18.95    15% off");
System.out.println("Chips       $1.79     15% off");
System.out.println("Coke        $2.99");
System.out.println("How many T-shirts do you want?");
String numberShirts = input.nextLine();
System.out.println("How many bags of potato chips?");
String numberChips = input.nextLine();
System.out.println("What about 12-pack coke?");
String numberCoke = input.nextLine();

//new code below
double tshirtTotal = TSHIRT_PRICE * numberShirts;
double chipsTotal = CHIPS_PRICE * numberChips;
double cokeTotal = (COKE_PRICE + 1.20) * numberCoke ;
tshirtTotal = tshirtTotal * .85;
chipsTotal  = chipsTotal * .85;
tshirtTotal = tshirtTotal * 1.06;
double finalTotal = tshirtTotal  + chipsTotal  + cokeTotal;
System.out.println("Your total is: " + finalTotal);