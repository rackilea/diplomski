import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class MyLookAndFeel {
  JFrame frame;
  JMenuBar menubar;
  MetalLookAndFeel metal;
  JMenu menu;

  public MyLookAndFeel() {
    metal = new MetalLookAndFeel();
    metal.setCurrentTheme(new MetalTheme());
    try {
      UIManager.setLookAndFeel(metal);
    }
    catch(UnsupportedLookAndFeelException e) {
      e.printStackTrace();
    }
    frame = new JFrame("Hello");

    frame.setUndecorated(true);
    frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

    menubar = new JMenuBar();
    menubar.setOpaque(true);
    menubar.setBackground(Color.green);

    menu = new JMenu("File");
    menubar.add(menu);
    frame.setJMenuBar(menubar);

    frame.setVisible(true);
    frame.setSize(100,100);

  }
  public class MetalTheme extends DefaultMetalTheme {

    @Override
    public ColorUIResource getMenuBackground() {
      return new ColorUIResource(Color.GREEN);
    }
    public ColorUIResource getWindowTitleBackground() {
        return new ColorUIResource(java.awt.Color.green);
    }
  }
  public static void main(String args[]) {
    new MyLookAndFeel();
  }
}