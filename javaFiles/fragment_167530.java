import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LayoutExample {
    private JFrame frame;
    private JPanel pane;
    private JPanel leftPane;
    private JPanel rightPane;
    private JPanel topPane;
    private JPanel bottomPane;
    public static void main (String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LayoutExample().createAndShowGui();
            }
        });
    }

    public void createAndShowGui() {
        frame = new JFrame("Layout Example");
        pane = new JPanel();
        leftPane = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 300); 
            }
        };
        rightPane = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 300);
            }
        };
        topPane = new JPanel();
        bottomPane = new JPanel();

        pane.setLayout(new FlowLayout());
        rightPane.setLayout(new GridLayout(2, 1, 5, 5));

        rightPane.add(topPane);
        rightPane.add(bottomPane);

        pane.add(leftPane);
        pane.add(rightPane);
        pane.setBorder(BorderFactory.createLineBorder(Color.green));
        leftPane.setBorder(BorderFactory.createLineBorder(Color.red));
        topPane.setBorder(BorderFactory.createLineBorder(Color.black));
        bottomPane.setBorder(BorderFactory.createLineBorder(Color.magenta));

        frame.setContentPane(pane);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}