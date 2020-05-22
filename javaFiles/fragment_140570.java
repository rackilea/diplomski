Scanner userInput = new Scanner(System.in);

System.out.print("Enter your order code: ");
// Get the entire code using Scanner.nextLine() instead of Scanner.nextDouble()
String code = userInput.nextLine();

// Get the first two characters (the adult meals)
int adultMeals = Integer.parseInt(code.substring(0, 2));
// Get the next four characters separated by a period (the price)
double price = Double.parseDouble(code.substring(2, 4) + "." + code.substring(4, 6));
// Get the next two characters (the child meals)
int childMeals = Integer.parseInt(code.substring(7, 8));
// Get the next four characters separated by a period (the child price)
double childPrice = Double.parseDouble(code.substring(8, 10) + "." + code.substring(10, 12));

/*
 * To calculate the subtotal, multiple the adult price by the number of adult
 * meals, and the child price by the number of child meals, then add the two
 * together.
 */
double subtotal = (price * adultMeals) + (childPrice * childMeals);
// The discount is 15% of the subtotal
double discount = subtotal * 0.15;
// Subtract the discount to get the total
double total = subtotal - discount;

String name = code.substring(12);

System.out.println("Name: " + name);
System.out.println("Adult meals: " + adultMeals);
System.out.println("Child meals: " + childMeals);
System.out.println("Subtotal: " + subtotal);
System.out.println("15% Discount: " + discount);
System.out.println("Total: " + total);