// Scan the amount
Scanner scanner = new Scanner(System.in);
System.out.print("Enter amount: ");
double amount = scanner.nextDouble();
scanner.close();

// convert into cents 
int cents = (int) (amount * 100);

// get dollars
int dollars = cents/100;
// cents left after dollars
cents = cents - dollars*100;

// get quarters
int quaters = cents/25;
// cents left after quarters
cents = cents - quaters*25;

// get dimes
int dimes = cents/10;
// cents left after dimes
cents = cents - dimes*10;

// get nickels
int nickels = cents/5;
// cents left after nickels
cents = cents - nickels*5;

// leftover cents are pennies
int pennies = cents;