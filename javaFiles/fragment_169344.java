import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

public class SimpleTableDemo extends JPanel {

  public SimpleTableDemo() {
    super(new GridLayout(1, 0));

    String[] columnNames = { "First Name", "Last Name", "Sport", "# of Years",
        "Vegetarian" };

    Object[][] data = {
        { "Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false) },
        { "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
        { "Sue", "Black", "Knitting", new Integer(2), new Boolean(false) },
        { "Jane", "White", "Speed reading", new Integer(20), new Boolean(true) },
        { "Joe", "Brown", "Pool", new Integer(10), new Boolean(false) } };

    final JTable table = new JTable(data, columnNames);
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    table.setFillsViewportHeight(true);

    final TableCellRenderer renderer = table.getDefaultRenderer(Object.class);
    table.setDefaultRenderer(Object.class, new TableCellRenderer() {
      @Override
      public Component getTableCellRendererComponent(JTable table,
          Object value, boolean isSelected, boolean hasFocus, int row,
          int column) {
        Component component = renderer.getTableCellRendererComponent(table,
            value, isSelected, hasFocus, row, column);
        String columnHeader = table.getColumnModel().getColumn(column)
            .getHeaderValue().toString();
        ((JComponent) component).setToolTipText(columnHeader);
        return component;
      }
    });

    // Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(table);

    // Add the scroll pane to this panel.
    add(scrollPane);
  }

  private static void createAndShowGUI() {
    // Create and set up the window.
    JFrame frame = new JFrame("SimpleTableDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create and set up the content pane.
    SimpleTableDemo newContentPane = new SimpleTableDemo();
    newContentPane.setOpaque(true); // content panes must be opaque
    frame.setContentPane(newContentPane);

    // Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}