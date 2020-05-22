import javax.swing.*;
import java.awt.*;
class Testing
{
  public void buildGUI()
  {
    JFrame f = new JFrame();

    JPanel o_panel = new JPanel();
    JPanel panel = new JPanel();
    panel.setMinimumSize(new Dimension(500,500));
    panel.setPreferredSize(new Dimension(500,500));
    panel.setMaximumSize(new Dimension(500,500));
    panel.setBackground(Color.RED);
    panel.setBorder(BorderFactory.createLineBorder(Color.GRAY,25));

    o_panel.add(panel);

    f.getContentPane().add(o_panel);
    f.pack();
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable(){
      public void run(){
        new Testing().buildGUI();
      }
    });
  }
}