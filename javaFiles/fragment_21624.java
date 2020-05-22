import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;

public class ScreenUI {

    private static final String FIRST_SCREEN = "first";

    private static final String SECOND_SCREEN = "second";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Multiscreen");
        CardLayout cl = new CardLayout();
        // set card layout
        frame.getContentPane().setLayout(cl);
        // build first screen
        JPanel firstScreen = new JPanel(new BorderLayout());
        firstScreen.add(new JScrollPane(new JList<>(new String[] {"One", "Two", "Three", "Four"})));
        JButton nextScreen = new JButton("Next");
        // action to show second screen, which is referenced per string constant
        nextScreen.addActionListener(e -> cl.show(frame.getContentPane(), SECOND_SCREEN)); 
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        buttonsPanel.add(nextScreen);
        firstScreen.add(buttonsPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(firstScreen, FIRST_SCREEN);
        // build second screen
        JPanel secondScreen = new JPanel(new BorderLayout());
        secondScreen.add(new JScrollPane(new JTree()));
        JButton previousScreen = new JButton("Previous");
        // action to show first screen, which is referenced per string constant
        previousScreen.addActionListener(e -> cl.show(frame.getContentPane(), FIRST_SCREEN));
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        buttonsPanel.add(previousScreen);
        secondScreen.add(buttonsPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(secondScreen, SECOND_SCREEN);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}