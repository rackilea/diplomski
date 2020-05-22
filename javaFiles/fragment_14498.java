import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class CustomJTableTest extends JPanel
{

  TableModel customRendererEditorTableModel = new TableModel();
  JTable table;

  public CustomJTableTest()
  {
    setLayout(new BorderLayout());

    table = new JTable(customRendererEditorTableModel);
    table.setPreferredScrollableViewportSize(new Dimension(500, 600));
    table.setRowSelectionAllowed(false);
    table.setRowHeight(300);
    table.getColumn("Custom JPanel").setCellRenderer(new CustomJPanelRenderer());
    table.getColumn("Custom JPanel").setCellEditor(new CustomJPanelEditor());

    JScrollPane scrollPane = new JScrollPane(table);
    add(scrollPane);

    JButton showControl = new JButton("Show Controls");
    showControl.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      { 
    // row 2
    TableCellEditor tableCellEditor = table.getColumnModel().getColumn(1).getCellEditor();
    java.awt.Component component = table.prepareEditor(tableCellEditor, 1, 1);
    if (component instanceof CustomJPanel)
    {
      CustomJPanel customJPanel = (CustomJPanel) component;
      customJPanel.setControlsVisible(true);
    }

    // row 1
    java.awt.Component component2 = table.prepareEditor(tableCellEditor, 0, 1);
    if (component2 instanceof CustomJPanel)
    {
      CustomJPanel customJPanel = (CustomJPanel) component2;
      customJPanel.setControlsVisible(true);
    }

    customRendererEditorTableModel.fireTableDataChanged();
      }
    });
    add(new JScrollPane(showControl), BorderLayout.SOUTH);
  }

  private static void createAndShowGUI()
  {
    JFrame frame = new JFrame("Custom JPanel");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JComponent newContentPane = new CustomJTableTest();
    newContentPane.setOpaque(true);
    frame.setContentPane(newContentPane);
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args)
  {
    javax.swing.SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
    createAndShowGUI();
      }
    });
  }
}