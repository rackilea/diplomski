import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableStackOf2 {
  private Component makeUI() {
    // TEST: UIManager.put("ComboBox.border", BorderFactory.createLineBorder(Color.RED));
    JTable table = new JTable();
    table.setModel(new DefaultTableModel(
      new Object[][] {
        {null, null},
        {null, null}
      },
      new String[] {
        "default", "BasicComboBoxUI"
      }));
    table.setGridColor(new Color(235, 235, 235));
    table.setRowHeight(20);
    table.setSelectionBackground(new Color(215, 230, 242));
    table.setSelectionForeground(new Color(0, 0, 0));

//     // @see https://stackoverflow.com/questions/38911818/remove-jcombobox-border-inside-jtable
//     // Nimbus TEST:
//     Painter<JComponent> emptyPainter = new Painter<JComponent>() {
//       @Override public void paint(Graphics2D g, JComponent c, int w, int h) {
//         /* Empty painter */
//       }
//     };
//     UIDefaults d = new UIDefaults();
//     d.put("TextField.borderPainter", emptyPainter);
//     d.put("TextField[Enabled].borderPainter", emptyPainter);
//     d.put("TextField[Focused].borderPainter", emptyPainter);
//     d.put("ComboBox:\"ComboBox.textField\"[Enabled].backgroundPainter", emptyPainter);
//     d.put("ComboBox:\"ComboBox.textField\"[Selected].backgroundPainter", emptyPainter);
//     d.put("ComboBox[Editable+Focused].backgroundPainter", emptyPainter);

    String[] model = {"Hello", "World"};

    JComboBox<String> editableCombobox = new JComboBox<String>(model) {
      // @see https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TabComponentsDemoProject/src/components/ButtonTabComponent.java
      // we don't want to update UI for this combo box
      @Override public void updateUI() {
        // Nimbus TEST: super.updateUI();
        setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
          @Override protected JButton createArrowButton() {
            JButton b = new JButton(new ArrowIcon());
            b.setBackground(Color.BLACK);
            b.setContentAreaFilled(false);
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createEmptyBorder());
            return b;
          }
        });
      }
    };
    editableCombobox.setEditable(true);
    // Nimbus TEST: editableCombobox.putClientProperty("Nimbus.Overrides", d);
    editableCombobox.setBorder(BorderFactory.createEmptyBorder());

    JTextField c = (JTextField) editableCombobox.getEditor().getEditorComponent();
    // Nimbus TEST: c.putClientProperty("Nimbus.Overrides", d);
    c.setBorder(BorderFactory.createEmptyBorder());

    JComboBox<String> defaultComboBox = new JComboBox<>(model);
    defaultComboBox.setEditable(true);
    defaultComboBox.setBorder(BorderFactory.createEmptyBorder());
    ((JComponent) defaultComboBox.getEditor().getEditorComponent()).setBorder(BorderFactory.createEmptyBorder());

    table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(defaultComboBox));
    table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(editableCombobox));

    return new JScrollPane(table);
  }
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      // UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new TableStackOf2().makeUI());
      f.pack();
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

// @see https://ateraimemo.com/Swing/ComboBoxBorder.html
class ArrowIcon implements Icon {
  @Override public void paintIcon(Component c, Graphics g, int x, int y) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.setPaint(Color.BLACK);
    int shift = 0;
    if (c instanceof AbstractButton && ((AbstractButton) c).getModel().isPressed()) {
      shift = 1;
    }
    g2.translate(x, y + shift);
    g2.drawLine(2, 3, 6, 3);
    g2.drawLine(3, 4, 5, 4);
    g2.drawLine(4, 5, 4, 5);
    g2.dispose();
  }
  @Override public int getIconWidth() {
    return 9;
  }
  @Override public int getIconHeight() {
    return 9;
  }
}