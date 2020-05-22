import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Nava extends JFrame implements ActionListener {
    JButton b1 = new JButton("Clear");
    JTextField t1 = new JTextField("Fubar", 10);

    public Nava() {
        this.setLayout(new GridLayout(2, 2));
        b1.addActionListener(this);
        // this.setSize(200, 200);

        add(t1);
        add(b1);

        b1.setMnemonic(KeyEvent.VK_C); // alt-c to activate button
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            t1.setText(""); 
        }
    }

    public static void main(String r[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Nava nava = new Nava();
                nava.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                nava.pack(); // let components and layout managers size themselves
                nava.setLocationByPlatform(true);
                nava.setVisible(true);
            }
        });
    }
}