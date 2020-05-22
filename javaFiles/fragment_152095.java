import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class LayoutDemo {
    private LayoutDemo() {
        JFrame frame = new JFrame("Demo");
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonHolder = new JPanel(new FlowLayout(FlowLayout.LEADING));
        frame.add(buttonHolder, BorderLayout.NORTH);
        JButton button = new JButton("Toggle visibility");
        buttonHolder.add(button);

        final JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(100, 200));
        left.setBackground(Color.BLUE);
        frame.add(left, BorderLayout.LINE_START);

        JLabel table = new JLabel("This pretends to be a table", SwingConstants.CENTER);
        table.setPreferredSize(new Dimension(400, 200));
        frame.add(table);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                left.setVisible(!left.isVisible());
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LayoutDemo();
            }
        });
    }
}