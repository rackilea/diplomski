import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;

public class MainApp2 {
  public JComponent makeUI() {
    JTree tree = new JTree(makeModel());
    tree.setEditable(true);
    tree.setCellRenderer(new NodeCellRenderer());
    tree.setCellEditor(new ButtonCellEditor());

    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(tree));
    return p;
  }
  private static DefaultMutableTreeNode makeModel() {
    Book b1 = new Book("The Book of Life");
    Book b2 = new Book("The Book of Death");
    User u1 = new User("Bianca");

    DefaultMutableTreeNode noCamada = new DefaultMutableTreeNode(u1);
    noCamada.add(new DefaultMutableTreeNode(b1));
    noCamada.add(new DefaultMutableTreeNode(b2));

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("Library", true);
    root.add(noCamada);
    return root;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame("Arvore de Navegacao");
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new MainApp2().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class NodePanel extends JPanel {
  public final JLabel nomeRadar = new JLabel();
  public final JLabel btnVisible = new JLabel(new ColorIcon(Color.RED));
  public final JLabel btnPaint = new JLabel(new ColorIcon(Color.GREEN));
  public final JLabel btnTrash = new JLabel(new ColorIcon(Color.BLUE));
  protected NodePanel() {
    super(new FlowLayout(FlowLayout.LEADING, 5, 5));
    add(nomeRadar);
    add(btnVisible);
    add(btnPaint);
    add(btnTrash);
  }
}

class NodeCellRenderer implements TreeCellRenderer {
  private final DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
  private final NodePanel renderer = new NodePanel();

  @Override public Component getTreeCellRendererComponent(
      JTree tree, Object value, boolean selected, boolean expanded,
      boolean leaf, int row, boolean hasFocus) {
    Component returnValue = null;
    if (value instanceof DefaultMutableTreeNode) {
      Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
      if (userObject instanceof Book) {
        Book feature = (Book) userObject;
        renderer.nomeRadar.setText(feature.getTitulo());
        returnValue = renderer;
      }
    }
    if (returnValue == null) {
      returnValue = defaultRenderer.getTreeCellRendererComponent(
          tree, value, selected, expanded, leaf, row, hasFocus);
    }
    return returnValue;
  }
}

class ButtonCellEditor extends AbstractCellEditor implements TreeCellEditor {
  private final DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
  private final NodePanel renderer = new NodePanel();

  public ButtonCellEditor() {
    renderer.setBackground(Color.ORANGE);
    renderer.nomeRadar.addMouseListener(new MouseAdapter() {
      @Override public void mousePressed(MouseEvent e) {
        System.out.println("clicou no nome");
        stopCellEditing();
      }
    });
    renderer.btnVisible.addMouseListener(new MouseAdapter() {
      @Override public void mousePressed(MouseEvent e) {
        System.out.println("clicou no olho");
        stopCellEditing();
      }
    });
    renderer.btnPaint.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        System.out.println("clicou no paint");
        stopCellEditing();
      }
    });
    renderer.btnTrash.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        System.out.println("clicou no trash");
        stopCellEditing();
      }
    });
    renderer.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        System.out.println("renderer");
        stopCellEditing();
      }
    });
  }

  @Override public boolean isCellEditable(EventObject e) {
    Object source = e.getSource();
    if (!(source instanceof JTree) || !(e instanceof MouseEvent)) {
      return false;
    }
    JTree tree = (JTree) source;
    Point p = ((MouseEvent) e).getPoint();
    TreePath path = tree.getPathForLocation(p.x, p.y);
    if (Objects.isNull(path)) {
      return false;
    }
    Object node = path.getLastPathComponent();
    if (!(node instanceof DefaultMutableTreeNode)) {
      return false;
    }
    Object userObject = ((DefaultMutableTreeNode) node).getUserObject();
    if (!(userObject instanceof Book)) {
      return false;
    }
    return super.isCellEditable(e);
  }

  @Override
  public Object getCellEditorValue() {
    return new Book(renderer.nomeRadar.getText());
  }

  @Override
  public Component getTreeCellEditorComponent(
      JTree tree, Object value, boolean isSelected, boolean expanded,
      boolean leaf, int row) {
    Component returnValue = null;
    if (value instanceof DefaultMutableTreeNode) {
      Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
      if (userObject instanceof Book) {
        Book feature = (Book) userObject;
        renderer.nomeRadar.setText(feature.getTitulo());
        returnValue = renderer;
      }
    }
    if (returnValue == null) {
      returnValue = defaultRenderer.getTreeCellRendererComponent(
          tree, value, isSelected, expanded, leaf, row, true);
    }
    return returnValue;
  }
}

class Book {
  String titulo;
  public String getTitulo() {
    return titulo;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  public Book(String titulo) {
    this.titulo = titulo;
  }
}

class User {
  String nomeUser;
  public String getNomeUser() {
    return nomeUser;
  }
  public void setNomeUser(String nomeUser) {
    this.nomeUser = nomeUser;
  }
  public User(String nome) {
    this.nomeUser = nome;
  }
  @Override public String toString() {
    return nomeUser;
  }
}

class ColorIcon implements Icon {
  private final Color color;
  protected ColorIcon(Color color) {
    this.color = color;
  }
  @Override public void paintIcon(Component c, Graphics g, int x, int y) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.translate(x, y);
    g2.setPaint(color);
    g2.fillRect(0, 0, getIconWidth(), getIconHeight());
    g2.dispose();
  }
  @Override public int getIconWidth() {
    return 16;
  }
  @Override public int getIconHeight() {
    return 16;
  }
}