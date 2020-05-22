import java.awt.*;
import javax.swing.*;

public class Test implements Runnable
{
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Test());
  }

  public void run()
  {
    JDialog dialog = new JDialog();
    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    dialog.setResizable(true);  // fixed mispelling here

    JPanel guiHolder = new JPanel();
    guiHolder.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.PAGE_START;
    gbc.weightx = 1.0;
    gbc.weighty = 1.0;
    guiHolder.add(new JLabel("my test"), gbc);

    dialog.add(guiHolder);
    dialog.setSize(new Dimension(320, 240));
    dialog.setVisible(true);  // fixed wrong method name here
  }
}