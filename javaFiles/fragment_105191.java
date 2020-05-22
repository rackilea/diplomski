public class StringValidation {
    public static void main(String[] args) {
        String letter = JOptionPane.showInputDialog("Please insert the letter");
        while (!letter.toLowerCase().matches("a|b|c|d|e|f|g|h|i|j|k")) {
            JOptionPane.showMessageDialog(null, "Please insert an appropriate letter");
            letter = JOptionPane.showInputDialog("Please insert the letter: ");
        }
        String letterString = letter.substring(0, 1);
        System.out.println(letterString);
    }
}