import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Flags {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Flags().startup();
      }
    });
  }

  public static void startup() {
    GridLayout Layout = new GridLayout(6, 4);
    JFrame menu = new JFrame("Flag Menu");
    //  menu.setResizable(false);
    //  menu.setSize(600, 400);
    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton tailand = new JButton("Tailand");
    JButton norway = new JButton("Norway");
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.weighty = 1;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.anchor = GridBagConstraints.SOUTH;
    panel.add(norway, gbc);
    gbc.weighty = 0;
    panel.add(tailand, gbc);

    menu.add(panel);
    panel.setBackground(Color.LIGHT_GRAY);
    tailand.setBackground(Color.WHITE);
    norway.setBackground(Color.WHITE);
    menu.pack();
    menu.setLocationRelativeTo(null);
    menu.setVisible(true);

  }
}