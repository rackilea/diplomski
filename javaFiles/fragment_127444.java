import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Images extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        new Images();
    }

    public Images() {
        setTitle("myTitle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setBounds(100, 100, 800, 800); call pack() instead
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //contentPane.setLayout(null); // never do that!
        JLabel lblNombreequipo = new JLabel("trying: ");
        lblNombreequipo.setBorder(new EmptyBorder(10, 40, 10, 10));
        //lblNombreequipo.setBounds(147, 110, 145, 14);
        contentPane.add(lblNombreequipo, BorderLayout.PAGE_START);
        //int coordY = 150;
        JPanel scrollPanel = new JPanel(new GridLayout(0, 1, 0, 50));
        contentPane.add(new JScrollPane(scrollPanel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        for (int i = 0; i < 10; i++) {
            JLabel myLabel = new JLabel("attempt: " + i);
            myLabel.setBorder(new EmptyBorder(20, 140, 20, 140));
            //myLabel.setBounds(147, coordY, 145, 14);
            scrollPanel.add(myLabel);
            //coordY = coordY + 150;
        }
        pack();
        // now the preferred size has been calculated, we can shorten the height
        Dimension d = getSize();
        setSize(new Dimension(d.width, 250));
        setLocationByPlatform(true);
        setMinimumSize(getSize());
        setVisible(true); //should be last
    }
}