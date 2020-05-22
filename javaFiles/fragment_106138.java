import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.tree.*;

public class MiddleXOfRootNodeIconTest {
  public JComponent makeUI() {
    int ow = UIManager.getIcon("Tree.openIcon").getIconWidth();
    int iw = 32;

    Icon icon1 = new ColorIcon(Color.GREEN, new Dimension(ow, iw));
    Icon icon2 = new ColorIcon(new Color(0x550000AA, true), new Dimension(iw, iw));

    JTree tree = new JTree();
    tree.setBorder(BorderFactory.createEmptyBorder(1, 1 + iw / 2, 1, 1));
    //TEST:
    //tree.setBorder(BorderFactory.createMatteBorder(1, 1 + iw / 2, 1, 1, Color.RED));
    tree.setCellRenderer(new CompoundTreeCellRenderer(icon1, iw));
    LayerUI<JTree> layerUI = new LayerUI<JTree>() {
      @Override public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        Graphics2D g2 = (Graphics2D) g.create();
        icon2.paintIcon(c, g2, 1 + ow / 2, 1);
        g2.dispose();
      }
    };

    JPanel p = new JPanel(new GridLayout(1, 3));
    p.add(new JScrollPane(new JTree()));
    p.add(new JScrollPane(new JLayer<JTree>(tree, layerUI)));
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new MiddleXOfRootNodeIconTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}
class CompoundTreeCellRenderer extends DefaultTreeCellRenderer {
  private static final Color ALPHA_ZERO = new Color(0x0, true);
  private final JPanel p = new JPanel(new GridBagLayout());
  private final GridBagConstraints ci = new GridBagConstraints();
  private final GridBagConstraints cl = new GridBagConstraints();
  private final JLabel icon = new JLabel();
  private final Icon gap1 = new ColorIcon(ALPHA_ZERO, new Dimension(2, 10));
  private final Icon gap2;
  private final Icon rootIcon;
  public CompoundTreeCellRenderer(Icon rootIcon, int iw) {
    super();
    Dimension d = new Dimension(2 + (iw - rootIcon.getIconWidth()) / 2, 10);
    this.rootIcon = rootIcon;
    //TEST: this.gap2 = new ColorIcon(Color.BLUE, d);
    this.gap2 = new ColorIcon(ALPHA_ZERO, d);
    this.setOpaque(false);
    p.setOpaque(false);
    ci.gridx = 0;
    ci.weightx = 1.0;
    cl.gridx = 1;
    cl.anchor = GridBagConstraints.WEST;
  }
  @Override public Component getTreeCellRendererComponent(
      JTree tree, Object value, boolean selected, boolean expanded,
      boolean leaf, int row, boolean hasFocus) {
    JLabel l = (JLabel) super.getTreeCellRendererComponent(
        tree, value, selected, expanded, leaf, row, hasFocus);
    l.setOpaque(false);
    p.removeAll();

    if (value.equals(tree.getModel().getRoot())) {
      icon.setIcon(rootIcon);
      l.setIcon(gap2);
    } else {
      icon.setIcon(l.getIcon());
      l.setIcon(gap1);
    }
    p.add(icon, ci);
    p.add(l, cl);
    return p;
  }
}
class ColorIcon implements Icon {
  private final Color color;
  private final Dimension dim;
  public ColorIcon(Color color, Dimension dim) {
    this.color = color;
    this.dim = dim;
  }
  @Override public void paintIcon(Component c, Graphics g, int x, int y) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.translate(x, y);
    g2.setColor(color);
    g2.fillRect(1, 1, dim.width - 2, dim.height - 2);
    g2.dispose();
  }
  @Override public int getIconWidth()  {
    return dim.width;
  }
  @Override public int getIconHeight() {
    return dim.height;
  }
}