import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Hanoi implements Runnable {

    @Override // java.lang.Runnable
    public void run() {
        showGui();
    }

    private JPanel createGridPanel() {

        // Number of rows will be calculated depending on total number
        // of components added but each row will contain no more than
        // three components.
        GridLayout gridLayout = new GridLayout(0, 3);

        JPanel gridPanel = new JPanel(gridLayout);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int number = (row + 3) + (col * 3);
                String text = String.valueOf(number);
                JButton button = new JButton(text);
                gridPanel.add(button);
            }
        }
        return gridPanel;
    }

    private void showGui() {
        JFrame frame = new JFrame("Hanoi");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(createGridPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Hanoi instance = new Hanoi();
        EventQueue.invokeLater(instance);
    }
}