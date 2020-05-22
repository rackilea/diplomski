public static void main(String[] args)   throws IOException
{
    // Gather user input.
    String input;
    BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));

    System.out.print("How much would you like to take out? ");
    input = myInput.readLine ();
    double principal = Double.parseDouble (input);        

    System.out.print("Enter the interest rate: ");
    input = myInput.readLine ();
    double rate = Double.parseDouble (input);

    System.out.print("Enter the number of years: ");
    input = myInput.readLine ();
    double years = Double.parseDouble (input);

    // Now do the calculations...
    double balance = balance(principal, rate, years); // Much clearer!
    System.out.println(balance);
}

public static double balance(double principal, double rate, double years) {
    // Calculate the end balance based on the parameters, and return it.
}