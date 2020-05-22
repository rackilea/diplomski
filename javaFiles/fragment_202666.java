public static int display_menu() // Not the main program but the main menu.
{
    String input;
    int mselect;
    input = JOptionPane.showInputDialog("Welcome!" + "\n\n1. Add tshirt order\n2. Edit tshirt order\n3. View current order\n4. Checkout" + "\n\nPlease enter your choice: ");
    // return Integer.parseInt(input);
    mselect = Integer.parseInt(input);
    return 0;
}