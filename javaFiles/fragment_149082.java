import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Example extends JFrame 
{
  JList list = null;

  Example() 
  {
    Container cp = getContentPane();

    cp.setLayout(new FlowLayout());
    ArrayList data = new ArrayList();

    data.add("Py");
    data.add("Piper");

    list = new JList(data.toArray());

    list.addListSelectionListener(new ListSelectionListener() 
    {

      public void valueChanged(ListSelectionEvent evt) 
      {
        // To avoid double value selected
        if (evt.getValueIsAdjusting())
                  return;
        System.out.println("Selected: " + list.getSelectedValue());
      }

    });

    cp.add(new JScrollPane(list), BorderLayout.CENTER);
  }

  public static void main(String[] s)
  {
    Example l = new Example();
    l.pack();
    l.setVisible(true);
  }
}