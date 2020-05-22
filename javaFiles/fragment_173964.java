import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example {

    public Example() {

        JButton button1 = new JButton("Hello button1");
        JButton button2 = new JButton("Hello button2") {
            @Override
            public Dimension getPreferredSize() {
                int width = super.getPreferredSize().width;
                return new Dimension(width, width);
            }
        };;

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.add(buttonPanel);

        JFrame frame = new JFrame();
        frame.setContentPane(contentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }

}