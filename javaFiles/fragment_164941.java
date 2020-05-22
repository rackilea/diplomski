import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.plaf.nimbus.*;

public class TreeCellBackgroundPainterTest {
  public JComponent makeUI() {
    UIDefaults d = new UIDefaults();
    AbstractRegionPainter rp = new AbstractRegionPainter() {
      @Override protected void doPaint(
          Graphics2D g, JComponent c, int width, int height, Object[] extendedCacheKeys) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
      }
      @Override protected final PaintContext getPaintContext() {
        return null;
      }
    };
    d.put("Tree:TreeCell[Enabled+Selected].backgroundPainter", rp);
    d.put("Tree:TreeCell[Focused+Selected].backgroundPainter", rp);

    JTree tree = new JTree();
    tree.putClientProperty("Nimbus.Overrides", d);
    tree.putClientProperty("Nimbus.Overrides.InheritDefaults", true);

    JPanel p = new JPanel(new GridLayout(1, 2, 2, 2));
    p.add(new JScrollPane(new JTree()));
    p.add(new JScrollPane(tree));
    return p;
  }
  public static void createAndShowGUI() {
    try {
      for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(laf.getName())) {
          UIManager.setLookAndFeel(laf.getClassName());
        }
      }
    } catch (ClassNotFoundException | InstantiationException
           | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      ex.printStackTrace();
    }
    JFrame f = new JFrame();
    f.getContentPane().add(new TreeCellBackgroundPainterTest().makeUI());
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
  public static void main(String... args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
}