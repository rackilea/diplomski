import javax.swing.JOptionPane;

public class Example {
    public static void main(String[] args) {
        if (System.console() != null) {
            System.out.println("Hello on the console");
        } else {
            JOptionPane.showMessageDialog(null, "Hello, there's no console");
        }
    }
}