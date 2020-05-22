import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Grid extends JFrame
{
    private JTextField t1, t2;
    private JCheckBox c1, c2;
    private JButton b1, b2, b3;
    private JPanel topPanel, bottomPanel;
    private JPanel eastPanel, centerPanel;
    private JLabel l1, l2;

    public Grid()
    {
         c1 = new JCheckBox("Snap to Grid");
         l1 = new JLabel("X:");
         t1 = new JTextField("8",3);

         topPanel = new JPanel();//uses flow layout by default
         topPanel.add(c1); topPanel.add(l1); topPanel.add(t1);

         c2 = new JCheckBox("Show Grid");
         l2 = new JLabel("Y:");
         t2 = new JTextField("8",3);

         bottomPanel = new JPanel();
         bottomPanel.add(c2);  bottomPanel.add(l2); bottomPanel.add(t2);

         centerPanel = new JPanel(new GridLayout(2,1));
         centerPanel.add(topPanel);
         centerPanel.add(bottomPanel);
         add(centerPanel,BorderLayout.CENTER);

         b1 = new JButton("Ok");
         b2 = new JButton("Cancel");
         b3 = new JButton("Help");

         eastPanel = new JPanel(new GridLayout(3,1));
         eastPanel.add(b1);
         eastPanel.add(b2);
         eastPanel.add(b3);
         add(eastPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {

        Grid app = new Grid();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(300,150);
        app.setVisible(true);
    }
}