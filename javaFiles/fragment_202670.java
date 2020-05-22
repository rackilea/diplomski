public class OnlineStore {

    String[] ColorType = {"blue", "green", "black"};
    final int COLOURS = 3;    // t choices
    int[] Color = new int[COLOURS];
    int sum;

    public int display_menu() // Not the main program but the main menu.
    {
        String input;
        input = JOptionPane.showInputDialog("Welcome!" + "\n\n1. Add tshirt order\n2. Edit tshirt order\n3. View current order\n4. Checkout" + "\n\nPlease enter your choice: ");
        // return Integer.parseInt(input);
        return Integer.parseInt(input);
    }

    public OnlineStore() // Switch-case program
    {
        boolean exit = false;
        do {
            switch (display_menu()) {
                case 1:
                    add_t();
                    break;
                case 2:
                    edit_t();
                    break;
                case 4:
                    exit = true;
                    break;
                default:  // If an error is encountered.
                    JOptionPane.showMessageDialog(null, "Oh dear! Error!");
                    break;
            }
        } while (!exit);
    }

    public final int add_t() {
        return 0;
    }

    public final int edit_t() {
        return 0;
    }

    public static void main(String[] args) // Main program
    {
        new OnlineStore(); // Call out the program.
    }

}