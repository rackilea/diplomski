import com.toedter.calendar.JDateChooser;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JDateChooserSample
{
  public static void main(String[] args)
  {
    JLabel label = new JLabel("No date");

    JDateChooser dateChooser = new JDateChooser();
    dateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener()
    {
      @Override
      public void propertyChange(PropertyChangeEvent evt)
      {
        if (evt.getPropertyName().equals("date"))
        {
          label.setText(String.valueOf(dateChooser.getDate()));
        }
      }
    });

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setLayout(new GridLayout(2, 1));
    f.getContentPane().add(dateChooser);
    f.getContentPane().add(label);
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}