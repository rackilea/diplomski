import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Examplerino {

    ArrayList<JTextField> tfs = new ArrayList<JTextField>();
    ArrayList<JButton> bts = new ArrayList<JButton>();

    int counter = 0;

    int amountBts = 4;
    int amountTfs = 3;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Examplerino();
            }
        });
    }

    public Examplerino() {

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());

        // Add new buttons to bts
        for (int i = 0; i < amountBts; i++) {
            bts.add(new JButton("b" + (i + 1)));
        }

        // Add new textfields to tfs
        for (int i = 0; i < amountTfs; i++) {
            tfs.add(new JTextField(3));
        }

        // Add buttons with action listener to the frame
        for (JButton b : bts) {
            b.addActionListener(new ButtonActionListener());
            frame.getContentPane().add(b);
        }

        // Add textfields to frame
        for (JTextField tf : tfs) {
            tf.setEditable(false);
            frame.getContentPane().add(tf);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    public class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (counter >= tfs.size()) {
                counter = 0;
            }
            tfs.get(counter).setText(((JButton) e.getSource()).getText());
            counter++;
        }
    }

}