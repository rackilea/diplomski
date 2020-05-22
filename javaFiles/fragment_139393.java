public void InsertMoney()
{
    String soption;
    productName = " Nothing";

    // Vending machine welcome dialog                   
    soption = JOptionPane.showInputDialog(
        "============================================"
        + "\nWelcome to the College Vending Machine!" 
        + "\n============================================"
        + "\n\nOptions: i for insert money, s for select item, q for quit."
        + "\n\n============================================");

    switch (soption) 
    {
    case "q":       // user chooses q to quit
        JOptionPane.showMessageDialog(null, "Have a Nice Day!");
        System.exit(0);     // terminate application
        break;
    case "i":       // if user chooses i: insert money;
        do
        {
            spaymentSum = JOptionPane.showInputDialog(
                "=============================" 
                + "\nPlease enter some money (in pence)" 
                + "\n=============================");   // Inserting money
            paymentSum = Integer.parseInt(spaymentSum); // Parsing for calculations
            if (paymentSum <= 0)
            {
                JOptionPane.showMessageDialog(null,"Must be a positive input! Try again.");
            }
        } while (paymentSum <= 0); // ADDED CHANGES HERE
        break;
    case "s":       // if user chooses s: select item
        break;
    }
}