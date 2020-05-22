public static void main(String[] args) {
  String amountString = JOptionPane.showInputDialog("Enter the amount you pay in cents,\n" +
        "followed by the cost of the item in cents.\n" +
        "The input must be in the form: pay:cost,\n" +
        "where pay is a whole number (100, 200, 300, etc) to a maximum of 900,\n" +
        "and cost is  a multiple of five (5, 10, 15, etc) to a maximum of 900");

  int pay, cost, change, originalChange, quarters, dimes, nickles;

  //this is the real meat of the solution
  String[] input = amountString.split(":");  //this creates a String array with 2 parts {"pay", "cost"}
  pay = Integer.parseInt(input[0]);  //This method (and the next) parse as int.
  cost = Integer.parseInt(input[1]);
  change = pay - cost;
  originalChange = change;

  quarters = change / 25;
  change = change % 25;
  dimes = change / 10;
  change = change %10;
  nickles = change / 5;

  JOptionPane.showMessageDialog(null, originalChange +
        " cents in coins can be given as:\n" +
        quarters + " quarters\n" +
        dimes + " dimes\n" +
        nickles + " nickles\n");
  System.exit(0);   //Note, unlike C++ This is unnecessary.
 //When the method ends there is no need to call System.exit(0);
 //The only time to use System.exit(0) is when it's outside of control flow.
 //The system was already going to end from the main method anyway so it doesn't change anything.
 //Pro tip: using return; (with nothing there) will also do the same thing.
}