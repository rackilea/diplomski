import java.awt.*;
import java.util.*;

import javax.swing.*;

public class ScrollingDemo implements Runnable
{
  public static void main(String args[])
  {
    SwingUtilities.invokeLater(new ScrollingDemo());
  }

  public void run()
  {
    JScrollPane sp1 = new JScrollPane(getJList(1));
    sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    JScrollPane sp2 = new JScrollPane(getJList(3));
    sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    JScrollBar sBar1 = sp1.getVerticalScrollBar();
    JScrollBar sBar2 = sp2.getVerticalScrollBar();

    // synchronize:
    sBar2.setModel(sBar1.getModel());

    JPanel p = new JPanel(new GridLayout(1,2));
    p.add(sp1);
    p.add(sp2);

    JFrame frame = new JFrame("Synch Scrolling");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(p, BorderLayout.CENTER);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public JList getJList(int factor)   
  {
    Vector<String> items = new Vector<String>();
    for(int i = 0; i < 5000; i++)
    {
      items.add(Integer.toString((i+1)*factor));
    }
    JList list = new JList(items);
    list.setPrototypeCellValue("XXXXXXXXXX");
    list.setVisibleRowCount(10);
    return list;
  }
}