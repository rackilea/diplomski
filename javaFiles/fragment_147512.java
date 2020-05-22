import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Demo_Large_Custom_Cursor_Simple
{
  static Insets An_Inset=new Insets(0,0,0,0);

  private static void createAndShowGUI()
  {
    JFrame frame=new JFrame("Demo_Large_Custom_Cursor_Simple");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container contentPane=frame.getContentPane();
    contentPane.setLayout(new FlowLayout());
    contentPane.setPreferredSize(new Dimension(2*80+15,2*80+15));

    int Font_Size=6;
    String Color="blue",Font_Face="Monospaced",
           Token_1="<Html>"+
                   "  <Table Border=0 Cellspacing=3 Cellpadding=3>"+
                   "    <Tr><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">1</Font></Td><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">A</Font></Td></Tr>"+
                   "    <Tr><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">\u2664</Font></Td><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">\u203b</Font></Td></Tr>"+
                   "  </Table>"+
                   "</Html>",
           Token_2="<Html>"+
                   "  <Table Border=0 Cellspacing=3 Cellpadding=3>"+
                   "    <Tr><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">2</Font></Td><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">B</Font></Td></Tr>"+
                   "    <Tr><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">\u2660</Font></Td><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">\u2638</Font></Td></Tr>"+
                   "  </Table>"+
                   "</Html>",
           Token_3="<Html>"+
                   "  <Table Border=0 Cellspacing=3 Cellpadding=3>"+
                   "    <Tr><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">3</Font></Td><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">C</Font></Td></Tr>"+
                   "    <Tr><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">\u2667</Font></Td><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">\u2668</Font></Td></Tr>"+
                   "  </Table>"+
                   "</Html>",
           Token_4="<Html>"+
                   "  <Table Border=0 Cellspacing=3 Cellpadding=3>"+
                   "    <Tr><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">4</Font></Td><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">D</Font></Td></Tr>"+
                   "    <Tr><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">\u2663</Font></Td><Td Align=Center><Font Size="+Font_Size+" Color="+Color+">\u262f</Font></Td></Tr>"+
                   "  </Table>"+
                   "</Html>";
    JButton Button_1=new JButton(Token_1);
    Button_1.setPreferredSize(new Dimension(80,80));
    Button_1.setFont(new Font(Font_Face,0,16));
    Button_1.setMargin(An_Inset);
    Button_1.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent evt) { Out(Button_1.getText().replaceAll("<[^>]*>"," ").replaceAll("( )+"," ")); } });
    contentPane.add(Button_1);

    JButton Button_2=new JButton(Token_2);
    Button_2.setPreferredSize(new Dimension(80,80));
    Button_2.setFont(new Font(Font_Face,0,16));
    Button_2.setMargin(An_Inset);
    Button_2.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent evt) { Out(Button_2.getText().replaceAll("<[^>]*>"," ").replaceAll("( )+"," ")); } });
    contentPane.add(Button_2);

    JButton Button_3=new JButton(Token_3);
    Button_3.setPreferredSize(new Dimension(80,80));
    Button_3.setFont(new Font(Font_Face,0,16));
    Button_3.setMargin(An_Inset);
    Button_3.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent evt) { Out(Button_3.getText().replaceAll("<[^>]*>"," ").replaceAll("( )+"," ")); } });
    contentPane.add(Button_3);

    JButton Button_4=new JButton(Token_4);
    Button_4.setPreferredSize(new Dimension(80,80));
    Button_4.setFont(new Font(Font_Face,0,16));
    Button_4.setMargin(An_Inset);
    Button_4.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent evt) { Out(Button_4.getText().replaceAll("<[^>]*>"," ").replaceAll("( )+"," ")); } });
    contentPane.add(Button_4);

    JMenuBar menuBar=new JMenuBar();
    JMenu menu=new JMenu("Menu");
    menu.add(new JMenuItem("Do nothing"));
    menuBar.add(menu);
    frame.setJMenuBar(menuBar);

    JPanel glass=new CustomGlassPane();
    glass.add(new CursorPanel(),BorderLayout.CENTER);
    frame.setGlassPane(glass);
    // This next call is necessary because JFrame.setGlassPane delegates to the root pane:
    // - https://docs.oracle.com/javase/9/docs/api/javax/swing/RootPaneContainer.html#setGlassPane-java.awt.Component-
    // - http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/javax/swing/JFrame.java#l738
    // And JRootPane.setGlassPane may call setVisible(false):
    // - https://docs.oracle.com/javase/9/docs/api/javax/swing/JRootPane.html#setGlassPane-java.awt.Component-
    // - http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/javax/swing/JRootPane.java#l663
    glass.setVisible(true);

    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setVisible(true);
  }

  static class CustomGlassPane extends JPanel
  {
    CustomGlassPane()
    {
      super(new BorderLayout());
      super.setOpaque(false);
    }

    @Override
    public boolean contains(int x,int y) { return false; }
  }

  static class CursorPanel extends JPanel
  {
    final BufferedImage cursorImage;
    Point mouseLocation;

    CursorPanel()
    {
      try { cursorImage=ImageIO.read(new File("C:/Cursor_Crosshair.PNG")); }
      catch (IOException x) { throw new UncheckedIOException(x); }

      setOpaque(false);
      long mask=AWTEvent.MOUSE_EVENT_MASK|AWTEvent.MOUSE_MOTION_EVENT_MASK;
      Toolkit.getDefaultToolkit().addAWTEventListener((AWTEvent e)->
      {
        switch (e.getID())
        {
          case MouseEvent.MOUSE_ENTERED :
          case  MouseEvent.MOUSE_EXITED :
          case   MouseEvent.MOUSE_MOVED :
          case MouseEvent.MOUSE_DRAGGED : capturePoint((MouseEvent)e);
            break;
        }
      },mask);

      // This turned out to be necessary, because the 'mouse exit' events don't always have a Point location which is outside the pane.
      Timer timer=new Timer(100,(ActionEvent e)->
      {
        if (mouseLocation!=null)
        {
          Point p=MouseInfo.getPointerInfo().getLocation();
          SwingUtilities.convertPointFromScreen(p,this);
          if (!contains(p)) setMouseLocation(null);
        }
      });
      timer.setRepeats(true);
      timer.start();
    }

    void capturePoint(MouseEvent e)
    {
      Component comp=e.getComponent();
      Point onThis=SwingUtilities.convertPoint(comp,e.getPoint(),this);
      boolean drawCursor=contains(onThis);

      if (drawCursor)
      {
        Window window=SwingUtilities.windowForComponent(this);
        if (window instanceof JFrame)
        {
          Container content=((JFrame)window).getContentPane();
          Point onContent=SwingUtilities.convertPoint(comp,e.getPoint(),content);
          Component deepest=SwingUtilities.getDeepestComponentAt(content,onContent.x,onContent.y);
          if (deepest==null) drawCursor=false;
        }
      }

      setMouseLocation(drawCursor?onThis:null);
    }

    void setMouseLocation(Point mouseLocation)
    {
      this.mouseLocation=mouseLocation;
      repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
      super.paintComponent(g);

      if (mouseLocation!=null)
      {
        int x=mouseLocation.x-(cursorImage.getWidth()/2)+1;
        int y=mouseLocation.y-(cursorImage.getHeight()/2)+1;

        g.drawImage(cursorImage,x,y,this);
      }
    }
  }

  private static void out(String message) { System.out.print(message); }
  private static void Out(String message) { System.out.println(message); }

  public static void main(String[] args) { SwingUtilities.invokeLater(new Runnable() { public void run() { createAndShowGUI(); } }); }
}