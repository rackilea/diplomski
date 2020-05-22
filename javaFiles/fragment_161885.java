import java.awt.*;
import java.awt.event.*;
// import java.util.List;
// import java.util.ArrayList;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.*;
import javax.swing.table.TableColumnModel;
//import ui.CustomHeaderUI;

public class JTableTest2 extends JFrame {
  private JTableTest2() {
    super("JTable Test");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(1, 1));
    createPanel();
    pack();
    setVisible(true);
  }

  JPanel panel = new JPanel(new GridLayout(1, 1));

  private void createPanel() {
    Object[] headers = {"Select", "Title", "Artist", "Length", "Title"};
    Object[][] sampleData = {
      {true, "Bat Outta Hell", "Meat Loaf", "673", "Bat Outta Hell"},
      {false, "Spanish Train", "Chris De Burgh", "358", "Spanish Train"},
      {true, "Bat Outta Hell", "Meat Loaf", "673", "Bat Outta Hell"}
    };
    JTable table = new JTable(sampleData, headers);

    // Custom TableRowSorter is completely irrelevant to this problem:
    // //Sort Order Part
    // ADU_SortOrder<TableModel> sortOrder = new ADU_SortOrder<>(table.getModel());
    // List<RowSorter.SortKey> sortKeys = new ArrayList<>();
    // sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
    // sortOrder.setSortKeys(sortKeys);
    // table.setRowSorter(sortOrder);

    JTableHeader header = table.getTableHeader();
    testPrintMouseListener(header);

    //Adds Custom UI
    CustomHeaderUI headerUI = new CustomHeaderUI();
    //XXX: headerUI.installUI(table.getTableHeader());
    table.getTableHeader().setUI(headerUI);

    testPrintMouseListener(header);

    panel.add(new JScrollPane(table));
    getContentPane().add(panel);
  }

  private static void testPrintMouseListener(JTableHeader header) {
    for (MouseListener l : header.getMouseListeners()) {
      System.out.println(l);
    }
  }

  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      new JTableTest2();
    });
  }
}

class CustomHeaderUI extends BasicTableHeaderUI {
  @Override public void installUI(JComponent c) {
    super.installUI(c);
    System.out.println("TEST: installUI");
  }
}