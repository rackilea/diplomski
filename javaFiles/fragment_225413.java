public static void main(String[] args){

  Scanner s = new Scanner(System.in); //Allow for reading user input from console

  boolean looping = true; //True so long as the user isn't done inputting prices.
                          //Initially true so that at least one price is entered
  double sum = 0.0;       //The sum of prices thus far
  while(looping){
    double nextPrice = getRangedDouble(s, "Enter a price in the range", 0.5, 10.0);
    sum = sum + nextPrice; //Add the price into the sum
    looping = getYNConfirm(s, "Add another item to your cart?");
  }
  System.out.println(String.format("%.2f", sum)); //Prints sum, limited to 2 decimal places
}