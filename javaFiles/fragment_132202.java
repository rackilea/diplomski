public class GetUserInput {

    public static String getUserInput() {
        return JOptionPane.showInputDialog("Type Something");
    }

    public static void main(String[] args) {
        System.out.println("User Input: " + getUserInput());
    }
}