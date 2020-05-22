import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;

public class Stackoverflow {

    // Initialize the color to your desired choice.
    private static Color color = Color.RED;

    public static void main(final String[] arguments) {
        final JFrame frame = new JFrame("Stackoverflow | Answer");
        EventQueue.invokeLater(() -> {
            final JMenuBar menuBar = new JMenuBar();
            final JMenu menu = new JMenu("Edit");
            // This is just for debugging.
            final JLabel currentColor = new JLabel(color.getRed() + "r " + color.getGreen() + "g " + color.getBlue() + "b");
            final JMenuItem item01 = new JMenuItem("Red");
            final JMenuItem item02 = new JMenuItem("Green");
            final JMenuItem item03 = new JMenuItem("Blue");
            item01.addActionListener((event -> {
                Stackoverflow.setColor(currentColor, Color.RED);
            }));
            item02.addActionListener((event -> {
                Stackoverflow.setColor(currentColor, Color.GREEN);
            }));
            item03.addActionListener((event -> {
                Stackoverflow.setColor(currentColor, Color.BLUE);
            }));
            final JMenu parent = new JMenu("Color");
            parent.add(currentColor);
            parent.add(item01);
            parent.add(item02);
            parent.add(item03);
            menu.add(parent);
            menuBar.add(menu);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLocationRelativeTo(null);
            frame.setJMenuBar(menuBar);
            frame.setVisible(true);
        });
    }

    public static void setColor(final JLabel label, final Color color) {
        // Update the text of the specified JLabel. Edit this part to change the actual font color.
        label.setText(color.getRed() + "r " + color.getGreen() + "g " + color.getBlue() + "b");
        Stackoverflow.color = color;
    }
}