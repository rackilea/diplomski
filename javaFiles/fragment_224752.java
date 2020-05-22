import javax.swing.JOptionPane;

public class Character_Charisma
{
    private static String input = "";

    public static int main() {
        Integer[] choices = {-4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        Integer input = (Integer) JOptionPane.showInputDialog(null, "Choose now...",
            "What is your Charisma modifier?", JOptionPane.QUESTION_MESSAGE, null, 
                                                                    // Use
                                                                    // default
                                                                    // icon
            choices, // Array of choices
            choices[0]); // Initial choice
            return input;
    }
}