import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Testing
{
  public void buildGUI()
  {
    JPanel p = new JPanel(new BorderLayout());
    JTextArea ta = new JTextArea(10,10);
    ta.setLineWrap(true);
    JScrollPane sp = new JScrollPane(ta,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
                                      ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    JLabel header = new JLabel("Header",JLabel.CENTER);
    JLabel footer = new JLabel("Footer",JLabel.CENTER);
    JScrollBar sBar = new JScrollBar();
    sp.getVerticalScrollBar().setModel(sBar.getModel());
    p.add(header,BorderLayout.NORTH);
    p.add(sp,BorderLayout.CENTER);
    p.add(footer,BorderLayout.SOUTH);

    for(int x = 0; x < 50; x++) ta.append(x+"\n");
    JFrame f = new JFrame();
    f.getContentPane().add(p);
    f.getContentPane().add(sBar,BorderLayout.EAST);
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