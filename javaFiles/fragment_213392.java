package stackoverflow;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DummyColor {

    private JFrame frame;
    private JLabel[] labels = new JLabel[4];

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DummyColor window = new DummyColor();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public DummyColor() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 657, 527);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lbl1 = new JLabel("First BOX");
        lbl1.setBounds(10, 11, 273, 194);

        frame.getContentPane().add(lbl1);

        JLabel label = new JLabel("Second BOX");
        label.setBounds(336, 11, 273, 194);
        frame.getContentPane().add(label);

        JLabel label_1 = new JLabel("Third  BOX");
        label_1.setBounds(10, 251, 273, 194);
        frame.getContentPane().add(label_1);

        JLabel label_2 = new JLabel("Fourth BOX");
        label_2.setBounds(347, 251, 273, 194);
        frame.getContentPane().add(label_2);

        labels[0] = lbl1;
        labels[1] = label;
        labels[2] = label_1;
        labels[3] = label_2;

        JButton btnPick = new JButton("Place");
        btnPick.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon imageIcon = new ImageIcon(DummyColor.class.getResource("/red.jpg"));
                int randInt = randInt(1, 4);
                System.out.println(randInt);

                for (int i = 0; i < labels.length; i++) {
                    JLabel jLabel = labels[i];

                    if (i == randInt - 1) {
                        jLabel.setIcon(imageIcon);
                    } else {
                        jLabel.setIcon(null);
                    }

                }

            }
        });
        btnPick.setBounds(10, 439, 57, 23);
        frame.getContentPane().add(btnPick);
    }

    private static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}