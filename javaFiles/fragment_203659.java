import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class ScrollingDemo2 implements Runnable
{
  public static void main(String args[])
  {
    SwingUtilities.invokeLater(new ScrollingDemo2());
  }

  public void run()
  {
    JScrollPane sp1 = new JScrollPane(getJList(100));
    sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    JScrollPane sp2 = new JScrollPane(getJList(200));
    sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    // synchronize:
    sp2.getVerticalScrollBar().addAdjustmentListener(new Synchronizer(sp1, sp2));

    JPanel p = new JPanel(new GridLayout(1,0));
    p.add(sp1);
    p.add(sp2);

    JFrame frame = new JFrame("Synch Scrolling 2");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(p, BorderLayout.CENTER);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  public JList getJList(int count)   
  {
    Vector<String> items = new Vector<String>();
    for(int i = 0; i < count; i++)
    {
      items.add(Integer.toString(i+1));
    }

    JList list = new JList(items);
    list.setPrototypeCellValue("XXXXXXXXXX");
    list.setVisibleRowCount(10);
    return list;
  }

  class Synchronizer implements AdjustmentListener
  {
    JScrollPane sp1, sp2;

    public Synchronizer(JScrollPane sp1, JScrollPane sp2)
    {
      this.sp1 = sp1;
      this.sp2 = sp2;
    }

    public void adjustmentValueChanged(AdjustmentEvent e)
    {
      if (! e.getValueIsAdjusting())
      {
        return;
      }

      JScrollBar vert1 = sp1.getVerticalScrollBar();
      JScrollBar vert2 = sp2.getVerticalScrollBar();

      int range1 = vert1.getMaximum() - vert1.getMinimum() -
                   vert1.getModel().getExtent();

      int range2 = vert2.getMaximum() - vert2.getMinimum() -
                   vert2.getModel().getExtent();

      float percent2 = (float) (vert2.getValue()) / range2;
      int newVal1 = (int) (percent2 * range1);

      vert1.setValue(newVal1);
    }
  }
}