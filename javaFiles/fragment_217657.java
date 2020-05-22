import java.util.Scanner;
import javax.swing.*;

public class TestSwing2 {

    private static final String EXIT = "exit";

    public static void main(String[] args) {
        // create window
        final JuanjoTestPanel testPanel = new JuanjoTestPanel();
        // launch it on the Swing event thread
        SwingUtilities.invokeLater(() -> createAndShowGui(testPanel));
        Scanner scanner = new Scanner(System.in);
        String line = "";
        while (!line.trim().equalsIgnoreCase(EXIT)) {
            System.out.print("Enter text: ");
            line = scanner.nextLine();
            System.out.println("Line entered: " + line);
            testPanel.printToWindow(line); // write to it
        }
        scanner.close();
        System.exit(0);
    }

    private static void createAndShowGui(JuanjoTestPanel testPanel) {
        JFrame frame = new JFrame("Test Swing2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(testPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}