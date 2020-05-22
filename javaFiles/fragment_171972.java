import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.accessibility.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public final class RemoveButtonInComboItemTest {
  public JComponent makeUI() {
    final JComboBox<String> c = new RemoveButtonComboBox<>(
        new DefaultComboBoxModel<>(new String[] {"aaaaa", "bbb", "cc", "d", "eeee"}));
    c.setPrototypeDisplayValue("MMMMMMMMMMMMMMMMMM");
    JPanel p = new JPanel();
    p.add(c);
    p.add(new JButton(new AbstractAction("add") {
      @Override public void actionPerformed(ActionEvent e) {
        MutableComboBoxModel<String> m = (MutableComboBoxModel<String>) c.getModel();
        m.insertElementAt(new Date().toString(), m.getSize());
      }
    }));
    p.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new RemoveButtonInComboItemTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class RemoveButtonComboBox<E> extends JComboBox<E> {
  private transient CellButtonsMouseListener cbml;
  public RemoveButtonComboBox(ComboBoxModel<E> aModel) {
    super(aModel);
  }
  @Override public void updateUI() {
    if (Objects.nonNull(cbml)) {
      JList<?> list = getList();
      if (Objects.nonNull(list)) {
        list.removeMouseListener(cbml);
        list.removeMouseMotionListener(cbml);
      }
    }
    super.updateUI();
    setRenderer(new ButtonsRenderer<E>(this));
    JList<?> list = getList();
    if (Objects.nonNull(list)) {
      cbml = new CellButtonsMouseListener();
      list.addMouseListener(cbml);
      list.addMouseMotionListener(cbml);
    }
  }
  protected JList<?> getList() {
    Accessible a = getAccessibleContext().getAccessibleChild(0);
    if (a instanceof BasicComboPopup) {
      return ((BasicComboPopup) a).getList();
    } else {
      return null;
    }
  }
}

class CellButtonsMouseListener extends MouseAdapter {
  private int prevIndex = -1;
  private JButton prevButton;
  private static void listRepaint(JList list, Rectangle rect) {
    if (Objects.nonNull(rect)) {
      list.repaint(rect);
    }
  }
  @Override public void mouseMoved(MouseEvent e) {
    JList list = (JList) e.getComponent();
    Point pt = e.getPoint();
    int index = list.locationToIndex(pt);
    if (!list.getCellBounds(index, index).contains(pt)) {
      if (prevIndex >= 0) {
        Rectangle r = list.getCellBounds(prevIndex, prevIndex);
        listRepaint(list, r);
      }
      index = -1;
      prevButton = null;
      return;
    }
    if (index >= 0) {
      JButton button = getButton(list, pt, index);
      ButtonsRenderer renderer = (ButtonsRenderer) list.getCellRenderer();
      if (Objects.nonNull(button)) {
        renderer.rolloverIndex = index;
        if (!button.equals(prevButton)) {
          Rectangle r = list.getCellBounds(prevIndex, index);
          listRepaint(list, r);
        }
      } else {
        renderer.rolloverIndex = -1;
        Rectangle r = null;
        if (prevIndex == index) {
          if (prevIndex >= 0 && Objects.nonNull(prevButton)) {
            r = list.getCellBounds(prevIndex, prevIndex);
          }
        } else {
          r = list.getCellBounds(index, index);
        }
        listRepaint(list, r);
        prevIndex = -1;
      }
      prevButton = button;
    }
    prevIndex = index;
  }
  @Override public void mousePressed(MouseEvent e) {
    JList list = (JList) e.getComponent();
    Point pt = e.getPoint();
    int index = list.locationToIndex(pt);
    if (index >= 0) {
      JButton button = getButton(list, pt, index);
      if (Objects.nonNull(button)) {
        listRepaint(list, list.getCellBounds(index, index));
      }
    }
  }
  @Override public void mouseReleased(MouseEvent e) {
    JList list = (JList) e.getComponent();
    Point pt = e.getPoint();
    int index = list.locationToIndex(pt);
    if (index >= 0) {
      JButton button = getButton(list, pt, index);
      if (Objects.nonNull(button)) {
        ButtonsRenderer renderer = (ButtonsRenderer) list.getCellRenderer();
        button.doClick();
        Rectangle r = list.getCellBounds(index, index);
        listRepaint(list, r);
      }
    }
  }
  @Override public void mouseExited(MouseEvent e) {
    JList list = (JList) e.getComponent();
    ButtonsRenderer renderer = (ButtonsRenderer) list.getCellRenderer();
    renderer.rolloverIndex = -1;
  }
  @SuppressWarnings("unchecked")
  private static JButton getButton(JList list, Point pt, int index) {
    Container c = (Container) list.getCellRenderer().getListCellRendererComponent(
        list, "", index, false, false);
    Rectangle r = list.getCellBounds(index, index);
    c.setBounds(r);
    //c.doLayout();
    pt.translate(-r.x, -r.y);
    Component b = SwingUtilities.getDeepestComponentAt(c, pt.x, pt.y);
    if (b instanceof JButton) {
      return (JButton) b;
    } else {
      return null;
    }
  }
}

class ButtonsRenderer<E> extends JPanel implements ListCellRenderer<E> {
  private static final Color EVEN_COLOR = new Color(230, 255, 230);
  private final RemoveButtonComboBox<E> comboBox;
  private JList list;
  private int index;
  public int rolloverIndex = -1;
  private final JLabel label = new DefaultListCellRenderer();
  private final JButton deleteButton = new JButton(new AbstractAction("x") {
    @Override public void actionPerformed(ActionEvent e) {
      MutableComboBoxModel m = (MutableComboBoxModel) list.getModel();
      if (m.getSize() > 1) {
        m.removeElementAt(index);
        comboBox.showPopup();
      }
    }
  }) {
    @Override public Dimension getPreferredSize() {
      return new Dimension(16, 16);
    }
  };
  public ButtonsRenderer(RemoveButtonComboBox<E> comboBox) {
    super(new BorderLayout(0, 0));
    this.comboBox = comboBox;
    label.setOpaque(false);
    setOpaque(true);
    add(label);
    deleteButton.setBorder(BorderFactory.createEmptyBorder());
    deleteButton.setContentAreaFilled(false);
    add(deleteButton, BorderLayout.EAST);
  }
  @Override public Component getListCellRendererComponent(
      JList<? extends E> list, E value, int index,
      boolean isSelected, boolean cellHasFocus) {
    label.setText(Objects.toString(value, ""));
    this.list = list;
    this.index = index;
    if (isSelected) {
      setBackground(list.getSelectionBackground());
      label.setForeground(list.getSelectionForeground());
    } else {
      setBackground(index % 2 == 0 ? EVEN_COLOR : list.getBackground());
      label.setForeground(list.getForeground());
    }
    MutableComboBoxModel m = (MutableComboBoxModel) list.getModel();
    if (index < 0 || m.getSize() - 1 <= 0) {
      setOpaque(false);
      deleteButton.setVisible(false);
      label.setForeground(list.getForeground());
    } else {
      setOpaque(true);
      boolean f = index == rolloverIndex;
      deleteButton.setVisible(true);
      deleteButton.getModel().setRollover(f);
      deleteButton.setForeground(f ? Color.WHITE : list.getForeground());
    }
    return this;
  }
}