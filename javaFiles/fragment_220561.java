import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Gui extends JFrame {

    public Gui() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
        // Set some charateristics of the frame
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setBackground(Color.black);
        this.setUndecorated(true);

        JButton a = new JButton("PRESS ME!");

        a.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser fc = new JFileChooser();
                fc.showOpenDialog(getParent());
            }
        });

        this.add(a);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Gui();
            }
        });
    }
}