import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class CustomJPanel extends JPanel
{

  JPanel colorPanel = new JPanel(new BorderLayout());
  JButton jButton = new JButton("Change Color");
  JSlider jSlider = new JSlider(JSlider.VERTICAL);

  public CustomJPanel()
  {
    jButton.setOpaque(true);
    jButton.addActionListener(new ActionListener()
    {

      @Override
      public void actionPerformed(ActionEvent e)
      {
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(4);

    switch (randomInt)
    {
      case (0):
        colorPanel.setBackground(Color.BLUE);
        break;
      case (1):
        colorPanel.setBackground(Color.BLACK);
        break;
      case (2):
        colorPanel.setBackground(Color.CYAN);
        break;
      default:
        colorPanel.setBackground(Color.GREEN);
        break;
    }
      }
    });
    jSlider.setOpaque(true);
    setLayout(new BorderLayout());
    add(colorPanel, BorderLayout.CENTER);
    add(jButton, BorderLayout.SOUTH);
    add(jSlider, BorderLayout.EAST);

    jSlider.setVisible(false);
    jButton.setVisible(false);
  }

  public void setControlsVisible(boolean visible)
  {
    jSlider.setVisible(visible);
    jButton.setVisible(visible);
  }
}