import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                JPanel p = new JPanel();
                p.setLayout(new GridBagLayout());

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                JLabel l = new JLabel("First Name");
                p.add(l, gbc);

                JTextField j = new JTextField(12);
                gbc.gridx++;
                p.add(j, gbc);

                gbc.gridx = 0;
                gbc.gridy++;
                gbc.gridwidth = GridBagConstraints.REMAINDER;

                JRadioButton j1 = new JRadioButton("Male");
                JRadioButton j2 = new JRadioButton("Female");
                ButtonGroup bg = new ButtonGroup();
                bg.add(j1);
                bg.add(j2);
                JPanel buttons = new JPanel();
                buttons.add(j1);
                buttons.add(j2);
                p.add(buttons, gbc);

                gbc.gridy++;
                gbc.insets = new Insets(100, 0, 0, 0);

                JButton b = new JButton("Submit");
                p.add(b, gbc);

                JScrollPane jp = new JScrollPane(p);
                frame.add(jp, BorderLayout.CENTER);
                //frame.pack();
                // This is just to force the point
                frame.setSize(250, 100);
                frame.setVisible(true);
            }
        });
    }

}