import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class LAF_TableCustomContainer2 extends JFrame {
  public LAF_TableCustomContainer2()  {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(300, 300);
    setVisible(true);
    setLocationRelativeTo(null);
  }

  public static void changeLAF(Container container, String laf) {
    try {
      UIManager.setLookAndFeel(laf);
    } catch (ClassNotFoundException | InstantiationException
           | IllegalAccessException | UnsupportedLookAndFeelException e) {
    }
    SwingUtilities.updateComponentTreeUI(container);
  }

  static final JFrame frame = new JFrame();

  public JComponent makeUI() {
    JPanel pV = new JPanel();
      pV.setLayout(new BoxLayout(pV, BoxLayout.PAGE_AXIS));

    String[] hdrsObjects = {"PanelSpinnerRadioButton Class Column"};
    Object[][] objectMatrix = new Object[3][1];
    objectMatrix[0][0] = new PanelSpinnerRadioButtonData(false, 10, 40);
    objectMatrix[1][0] = new PanelSpinnerRadioButtonData(true,  20, 40);
    objectMatrix[2][0] = new PanelSpinnerRadioButtonData(false, 30, 40);

      JTable table = new JTable(new DefaultTableModel(objectMatrix, hdrsObjects)) {
          @Override public void updateUI() {
              super.updateUI();
              setRowHeight(30);
              TableColumn tc = getColumn("PanelSpinnerRadioButton Class Column");
              tc.setCellRenderer(new PSRBTableCellRenderer());
              tc.setCellEditor(new PSRBTableCellEditor());
          }
      };
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//     table.setRowHeight(30);
//     TableColumn tc = table.getColumn("PanelSpinnerRadioButton Class Column");
//     tc.setCellRenderer(new PSRBTableCellRenderer());
//     tc.setCellEditor(new PSRBTableCellEditor());

    JPanel pH = new JPanel();
    pH.setLayout(new BoxLayout(pH, BoxLayout.LINE_AXIS));

    JButton bMetal = new JButton("Metal");
    bMetal.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        changeLAF(pV, "javax.swing.plaf.metal.MetalLookAndFeel");
      }
    });

    JButton bMotif = new JButton("Motif");
    bMotif.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        changeLAF(pV, "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
      }
    });

    JButton bNimbus = new JButton("Nimbus");
    bNimbus.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        changeLAF(pV, "javax.swing.plaf.nimbus.NimbusLookAndFeel");
      }
    });
    pH.add(bMetal);
    pH.add(bMotif);
    pH.add(bNimbus);

    pV.add(pH);
    pV.add(scrollPane);
    return pV;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      LAF_TableCustomContainer2 f = new LAF_TableCustomContainer2();
      f.getContentPane().add(f.makeUI());
    });
  }
}

class PanelSpinnerRadioButtonData {
  private boolean opt02 = false;
  private Integer from = 0;
  private Integer size = 1;

  PanelSpinnerRadioButtonData() {
    this(false, 5, 10);
  }
  PanelSpinnerRadioButtonData(boolean opt02, Integer from, Integer size) {
    this.opt02 = opt02;
    this.from = from;
    this.size = size;
  }
  public boolean getOption() {
    return opt02;
  }
  public Integer getFrom() {
    return from;
  }
  public Integer getSize() {
    return size;
  }
}

class PanelSpinnerRadioButton extends JPanel {
  public final JRadioButton jrbOption01 = new JRadioButton("01");
  public final JRadioButton jrbOption02 = new JRadioButton("12");
  public final JSpinner jspnValues = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1));

  private final JPanel panel = new JPanel();

  PanelSpinnerRadioButton() {
    this(new PanelSpinnerRadioButtonData(false, 20, 40));
  }

  PanelSpinnerRadioButton(PanelSpinnerRadioButtonData data) {
    super();

    panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
    panel.add(jrbOption01);
    panel.add(jrbOption02);
    panel.add(Box.createRigidArea(new Dimension(5, 0)));
    panel.add(new JSeparator(JSeparator.VERTICAL));
    panel.add(Box.createRigidArea(new Dimension(5, 0)));
    panel.add(jspnValues);
    ButtonGroup bg = new ButtonGroup();
    bg.add(jrbOption01);
    bg.add(jrbOption02);
    ((SpinnerNumberModel) jspnValues.getModel()).setMaximum(data.getSize());
    setData(data);

    init();
  }

  private void init() {
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    setBackground(new Color(0, 0, 0, 0));
    add(panel);
  }

  public void setData(PanelSpinnerRadioButtonData data) {
    if (data.getOption()) {
      jrbOption02.setSelected(true);
    } else {
      jrbOption01.setSelected(true);
    }
    ((SpinnerNumberModel) jspnValues.getModel()).setValue(data.getFrom());
  }

  // Used in PSRBTableCellEditor.getCellEditorValue()
  public PanelSpinnerRadioButtonData getData() {
    return new PanelSpinnerRadioButtonData(
             jrbOption02.isSelected(),
             (Integer)((SpinnerNumberModel) jspnValues.getModel()).getValue(),
             (Integer)((SpinnerNumberModel) jspnValues.getModel()).getMaximum());
  }
}

class PSRBTableCellRenderer implements TableCellRenderer {
  private final PanelSpinnerRadioButton renderer = new PanelSpinnerRadioButton();
  @Override public Component getTableCellRendererComponent(
    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if (value instanceof PanelSpinnerRadioButtonData) {
      renderer.setData((PanelSpinnerRadioButtonData) value);
    }
    return renderer;
  }
}

class PSRBTableCellEditor extends AbstractCellEditor implements TableCellEditor {
  private final PanelSpinnerRadioButton editor = new PanelSpinnerRadioButton();
  @Override public Object getCellEditorValue() {
    return editor.getData();
  }
  @Override public Component getTableCellEditorComponent(
    JTable table, Object value, boolean isSelected, int row, int column) {
    if (value instanceof PanelSpinnerRadioButtonData) {
      editor.setData((PanelSpinnerRadioButtonData) value);
    }
    return editor;
  }
}