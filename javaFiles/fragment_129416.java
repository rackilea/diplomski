import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

public static void main(String[] args) {
    System.out.println("Hello World!");
    final JFrame frame = new JFrame();
    frame.setTitle("Simple example");
    frame.setSize(600, 400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setLayout(new BorderLayout());

    JPanel contentPanel = new JPanel(new GridBagLayout());
    frame.add(contentPanel);

    JLabel expText = new JLabel("Welcome to the experiment");
    expText.setPreferredSize(new Dimension(150, 40));
    expText.setVisible(true);

    final JButton startButton = new JButton("Start");
    startButton.setPreferredSize(new Dimension(450, 40));
    startButton.setPreferredSize(new Dimension(450, 40));
    startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            startButton.setText("Continue");
        }

    });

    contentPanel.add(expText, new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.NORTHWEST,
            GridBagConstraints.HORIZONTAL, new Insets(0, 200, 0, 100), 0, 0));
    contentPanel.add(startButton, new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.NORTHWEST,
            GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
    contentPanel.add(Box.createVerticalGlue(), new GridBagConstraints(0, 1, 2, 2, 1, 1,
            GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }
}