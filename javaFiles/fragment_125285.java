import javax.swing.*;
import java.awt.*;

public class EqualWidthButtons
{
  public static void main(String[] args)
  {
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());

    GridBagConstraints gb = new GridBagConstraints();
    gb.gridx = 0;
    gb.gridy = 0;
    gb.gridwidth = 3;
    gb.fill = GridBagConstraints.HORIZONTAL;
    panel.add(new JTextField(20), gb);

    gb.gridwidth = 1;
    gb.gridy++;
    gb.weightx = 1.0; // This is the important line
    panel.add(new JButton("1"), gb);

    gb.gridx++;
    panel.add(new JButton("2"), gb);

    gb.gridx++;
    panel.add(new JButton("3"), gb);

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new GridBagLayout());
    frame.getContentPane().add(panel, new GridBagConstraints());
    frame.setBounds(300, 200, 400, 300);
    frame.setVisible(true);
  }
}