import javax.swing.*;
import java.awt.*;


public class Main extends JPanel
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Application Name");
        JPanel iconPanel = new JPanel();
        JPanel grid = new JPanel(new FlowLayout());
        JButton firewallButton = new JButton("Firewall");
        JButton networkButton = new JButton("Network");
        JButton printerButton = new JButton("Printer");


        frame.add(iconPanel);
        iconPanel.add(firewallButton);
        iconPanel.add(networkButton);
        iconPanel.add(printerButton);
        grid.setBackground(Color.GREEN);

        frame.setLayout(new GridLayout(1,2,3,3));
        frame.add(grid);
        frame.add(iconPanel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}