Scanner keyboard = new Scanner(System.in);
System.out.println("Enter item name:");
String item;
keyboard.nextLine();
System.out.println("Original Price of item:");
double originalPrice;
keyboard.nextDouble();
System.out.println("Marked up percentage:");
double markedUpPercentage;
keyboard.nextDouble();
markedUpPercentage = markedUpPercentage/100; //this is what you want
System.out.println("Sales tax rate:");
double salesTaxRate;
keyboard.nextDouble();
salesTaxRate = salesTaxRate/100; //same thing here

//now output
System.out.println("Item to be sold: " + item);
System.out.println("Original price of the item: " + originalPrice);
System.out.println("Price after mark up: " + (originalPrice + originalPrice * markedUpPrice));
//similarly, do for sales tax