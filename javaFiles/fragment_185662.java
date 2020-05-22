import javax.swing.JOptionPane;

public class Sequences {

    /**
     * @param args
     */
    public static void main(String[] args) {
        calculateSequences();
    }// ends main

    public static void calculateSequences() {
        int value;
        String valueInput = JOptionPane.showInputDialog("Value");
        value = Integer.parseInt(valueInput);

        while (value > 0) {
            if (value == 1) {
                System.out.println("Value is equal to 1, closing down");
                System.exit(0);

            } else if ((value % 2) == 0) {
                System.out.println(value + " will be divided by 2");
                value = value / 2;
                System.out.println("Value is even " + value);

            } else {
                System.out.println(value + " will be multiplied by 3 and + 1");
                value = 3 * value + 1;
                System.out.println("Value is " + value);

            }
        }

    }// ends calculateSequences

}