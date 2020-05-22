import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ExampleComboBoxEditor3 {
  public Component makeUI() {
    TheModel[] items = {
      new TheModel(0, true, true, "00000"),
      new TheModel(1, true, false, "11111"),
      new TheModel(2, false, true, "22222"),
      new TheModel(3, false, false, "33333")
    };
    JComboBox<TheModel> internalComboBox = new JComboBox<>(items);
    internalComboBox.setEditable(true);
    internalComboBox.setEditor(new TheComboBoxEditor(internalComboBox.getFont()));
    internalComboBox.setRenderer(new TheComboBoxRenderer<>(internalComboBox.getFont()));
    internalComboBox.setMaximumRowCount(4);
    // internalComboBox.addActionListener(e -> {
    //   System.out.println("You chose " + ((JComboBox) e.getSource()).getSelectedItem() + "!");
    // });
    internalComboBox.addItemListener(e -> {
      if (e.getStateChange() == ItemEvent.SELECTED) {
        System.out.println("You chose " + ((JComboBox) e.getSource()).getSelectedItem() + "!");
        ((JComboBox) e.getSource()).getEditor().selectAll();
      }
    });

    JPanel outer = new JPanel();
    outer.add(internalComboBox);
    outer.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    return outer;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new ExampleComboBoxEditor3().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class TheModel {
  private Boolean enabled = true;
  private Boolean defaultOperation = true;
  private String text = "";
  public int index = -1;

  public TheModel(int idx, Boolean enabled, Boolean defaultOperation, String text) {
    this.enabled = enabled;
    this.defaultOperation = defaultOperation;
    this.text = text;
    this.index = idx;
  }
  public Boolean getEnabled() {
    return enabled;
  }
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }
  public Boolean getDefaultOperation() {
    return defaultOperation;
  }
  public void setDefaultOperation(Boolean defaultOperation) {
    this.defaultOperation = defaultOperation;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  @Override
  public String toString() {
    return "TheModel{" + "enabled=" + enabled + ", defaultOperation=" + defaultOperation
      + ", text=" + text + '}';
  }
}

class TheComboBoxRenderer<E extends TheModel> implements ListCellRenderer<E> {
  protected ThePanel renderer;
  public TheComboBoxRenderer(Font extFont) {
    renderer = new ThePanel(new TheModel(-1, false, false, ""), extFont);
  }
  @Override
  public Component getListCellRendererComponent(JList<? extends E> list, E value,
      int index, boolean isSelected, boolean cellHasFocus) {
    renderer.setData(value);
    renderer.setBackground(isSelected ? new Color(200, 200, 255) : Color.WHITE);
    return renderer;
  }
}

class TheComboBoxEditor implements ComboBoxEditor {
  protected ThePanel editor;
  public TheComboBoxEditor(Font extFont) {
    super();
    editor = new ThePanel(new TheModel(-1, false, false, ""), extFont);
    editor.setBorder(BorderFactory.createLineBorder(Color.GRAY));
  }
  @Override
  public void selectAll() {
    editor.selectAll();
    // editor.requestFocus(); // <-- The focus moves from jtfText to editor.
  }
  @Override
  public Object getItem() {
    return editor.getData();
  }
  @Override
  public void setItem(Object anObject) {
    if (anObject instanceof TheModel) {
      TheModel d = (TheModel) anObject;
      editor.setData(d);
    } else {
      editor.setData(new TheModel(-1, false, false, ""));
    }
  }
  @Override
  public Component getEditorComponent() {
    return editor;
  }
  @Override
  public void addActionListener(ActionListener l) {
    System.out.println("addActionListener: " + l.getClass().getName());
    editor.addActionListener(l);
  }
  @Override
  public void removeActionListener(ActionListener l) {
    System.out.println("removeActionListener: " + l.getClass().getName());
    editor.removeActionListener(l);
  }
}

class ThePanel extends JPanel {
  private Font intFont = new Font("Monospaced", Font.PLAIN, 8);
  // Since there is no Unselected.png etc,
  // use JCheckBox instead of JToggleButton instead.
  public final JCheckBox jtbEnabled = new JCheckBox();
  public final JCheckBox jtbDefaultOperation = new JCheckBox();
  public final JTextField jtfText = new JTextField("", 10);
  private TheModel data;

  public ThePanel(TheModel data, Font extFont) {
    super();
    this.data = data;
    setData(data);

    jtbEnabled.addActionListener(e -> {
      Container c = SwingUtilities.getAncestorOfClass(JComboBox.class, this);
      if (c instanceof JComboBox) {
        JComboBox<?> combo = (JComboBox<?>) c;
        TheModel o = (TheModel) combo.getItemAt(data.index);
        boolean b = ((JCheckBox) e.getSource()).isSelected();
        o.setEnabled(b);
        jtbDefaultOperation.setEnabled(b);
      }
    });
    jtbEnabled.setOpaque(false);
    jtbEnabled.setFocusable(false);

    jtbDefaultOperation.addActionListener(e -> {
      Container c = SwingUtilities.getAncestorOfClass(JComboBox.class, this);
      if (c instanceof JComboBox) {
        JComboBox<?> combo = (JComboBox<?>) c;
        TheModel o = (TheModel) combo.getItemAt(data.index);
        o.setDefaultOperation(((JCheckBox) e.getSource()).isSelected());
      }
    });
    jtbDefaultOperation.setOpaque(false);
    jtbDefaultOperation.setFocusable(false);

    jtfText.addActionListener(e -> {
      Container c = SwingUtilities.getAncestorOfClass(JComboBox.class, this);
      if (c instanceof JComboBox) {
        JComboBox<?> combo = (JComboBox<?>) c;
        TheModel o = (TheModel) combo.getItemAt(data.index);
        o.setText(((JTextField) e.getSource()).getText());
      }
    });
    jtfText.setBorder(BorderFactory.createEmptyBorder());
    jtfText.setOpaque(false);

    setOpaque(true);
    setBackground(Color.WHITE);
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

    add(Box.createRigidArea(new Dimension(2, 0)));
    add(jtbEnabled);
    add(jtbDefaultOperation);
    add(jtfText);
    add(Box.createRigidArea(new Dimension(2, 0)));
  }

  public TheModel getData() {
    return new TheModel(
        data.index,
        jtbEnabled.isSelected(),
        jtbDefaultOperation.isSelected(),
        jtfText.getText());
  }

  public void setData(TheModel data) {
    this.data.index = data.index;
    jtbEnabled.setSelected(data.getEnabled());
    jtbDefaultOperation.setEnabled(data.getEnabled());
    jtbDefaultOperation.setSelected(data.getDefaultOperation());
    jtfText.setText(data.getText());
  }
  public void selectAll() {
      jtfText.requestFocusInWindow();
      jtfText.selectAll();
  }
  public void addActionListener(ActionListener l) {
    jtfText.addActionListener(l);
    jtbEnabled.addActionListener(l);
    jtbDefaultOperation.addActionListener(l);
  }
  public void removeActionListener(ActionListener l) {
    jtfText.removeActionListener(l);
    jtbEnabled.removeActionListener(l);
    jtbDefaultOperation.removeActionListener(l);
  }
}