import java.util.Arrays;
import javax.swing.JOptionPane;

public class Foo {
    static String [] product = {"Shirts", "Jeans", "Hats", "Pants", "Shoes"};
    static int [] q = new int[5];
    static int total;
    private static int quantity = 1; // Either input this value from the user or initialized it with your own value

    public static void main(String[] args) {


        for (int count = 0; count < product.length; count++) {
            String input = JOptionPane.showInputDialog("How many " + product[count] + "would     you like to purchase?");
            q[count] = Integer.parseInt(input);
        }

        System.out.println(Arrays.toString(q));

        System.out.println(calcTotal());
    }

    public static double calcTotal() { for (int i = 0; i < product.length; i++) { total += (getPrice(i) * quantity); } return total; }

    private static int getPrice(int i) {
        return q[i];
    }
}