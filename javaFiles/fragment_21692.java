package Core;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

// Create a simple GUI window
public class win {

    private static void createWindow() {

        // Create and set up the window.
        JFrame frame = new JFrame("PDF Denoiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // My edit
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel label1 = new JLabel("Image File");
        JLabel label2 = new JLabel("Destination");
        JLabel label3 = new JLabel("Preview");

        JTextField current = new JTextField();
        JTextField dest = new JTextField();
        JTextArea preview = new JTextArea();

        JButton choose1 = new JButton("Search1");
        JButton choose2 = new JButton("Search2");
        JButton algo1 = new JButton("MDWM");
        JButton algo2 = new JButton("BFMR");
        JButton algo3 = new JButton("Mine");

        // Horizontal arrangement
        layout.setHorizontalGroup(layout
                .createSequentialGroup()
                .addGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(label1)
                                .addComponent(label2).addComponent(label3))
                .addGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(current)
                                .addComponent(dest).addComponent(preview))
                .addGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(choose1)
                                .addComponent(choose2).addComponent(algo1).addComponent(algo2).addComponent(algo3)));

        layout.linkSize(SwingConstants.HORIZONTAL, choose1, choose2, algo1, algo2, algo3);

        // Vertical arrangement
        layout.setVerticalGroup(layout
                .createSequentialGroup()
                .addGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label1)
                                .addComponent(current).addComponent(choose1))
                .addGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(label2)
                                .addComponent(dest).addComponent(choose2))
                .addGroup(
                        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(label3)
                                .addComponent(preview)
                                .addGroup(
                                        layout.createSequentialGroup().addComponent(algo1).addComponent(algo2)
                                                .addComponent(algo3))));

        // Display the window.
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        createWindow();

    }
}