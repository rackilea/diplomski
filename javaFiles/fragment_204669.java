// Create a new Scanner object that will read input from System.in (stdin).
 Scanner var = new Scanner(System.in);

 // Declare some variables. The scanner hasn't done anything significant yet.
 double fnum, snum, answer;

 // Print a line to stdout.
 System.out.println("Enter first number: ");

 // Block until the scanner (i.e. stdin) receives a token. By default, the
 // Scanner will use whitespace to tokenize anything that comes in on
 // System.in. nextDouble() will try to parse the first available token
 // into a double. If the parsing succeeds, assign the parsed value to fnum.
 fnum = var.nextDouble();

 // Same thing as above, but for snum.
 System.out.println("Enter second number: ");
 snum = var.nextDouble();

 ...