import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DemoJOption {
    public static void main(String args[]) {
        int n = JOptionPane.showOptionDialog(new JFrame(), "Message", 
        "Title", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
        null, new Object[] {"Yes", "No"}, JOptionPane.YES_OPTION);

        if (n == JOptionPane.YES_OPTION) {
            System.out.println("Yes");
        } else if (n == JOptionPane.NO_OPTION) {
            System.out.println("No");
        } else if (n == JOptionPane.CLOSED_OPTION) {
            System.out.println("Closed by hitting the cross");
        }
    }
}