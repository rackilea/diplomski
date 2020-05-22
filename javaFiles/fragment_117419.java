import java.awt.EventQueue;
import javax.swing.JOptionPane;

/**
 * @see https://stackoverflow.com/a/24875960/230513
 */
public class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                String input = JOptionPane.showInputDialog(
                    "Enter the x coordinate of the circle");
                int xc = Integer.parseInt(input);
                System.out.println(xc);
            }
        });
    }
}