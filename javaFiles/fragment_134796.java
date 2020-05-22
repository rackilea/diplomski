import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame("Frame");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JButton button = new JButton("Button");
                frame.add(button);

                frame.setAlwaysOnTop(true);
                frame.setSize(500, 500);
                frame.setLocation(500, 500);

                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane optionPane = new JOptionPane("Option Pane");
                        optionPane.showMessageDialog(frame, "Message!"); // if you put null instead of frame, the option pane will be behind the frame
                    }
                });

                frame.setVisible(true);
            }
        });
    }
}