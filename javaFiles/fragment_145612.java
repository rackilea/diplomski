import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndDisplayGui();
            }
        });
    }

    private static void createAndDisplayGui() {
        JFrame frame = new JFrame("Test Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TestPanel panel = new TestPanel();
        frame.add(panel);               // add the panel as a component in the frame
        frame.addWindowListener(panel); // add the panel as a listener to the frame
        frame.pack();                   // lay out and size the frame
        frame.setVisible(true);         // display the frame
    }
}