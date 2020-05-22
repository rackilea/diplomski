import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

//code based on posts by @camickr     

public class TableFilterRow implements TableColumnModelListener {

    private static final long serialVersionUID = 1L;
    private JFrame frame = new JFrame();
    private JTable table = new JTable(3, 5);
    private JScrollPane scrollPane = new JScrollPane(table);
    // Panel for text fields
    private JPanel filterRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

    public TableFilterRow() {
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.getColumnModel().addColumnModelListener(this);
        filterRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        for (int i = 0; i < table.getColumnCount(); i++) {
            filterRow.add(new JTextField(" Sum at - " + i));
        }
        columnMarginChanged(new ChangeEvent(table.getColumnModel()));
        frame.add(scrollPane);
        frame.add(filterRow, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    //  Implement TableColumnModelListener methods
    //  (Note: instead of implementing a listener you should be able to
    //  override the columnMarginChanged and columMoved methods of JTable)
    @Override
    public void columnMarginChanged(ChangeEvent e) {
        TableColumnModel tcm = table.getColumnModel();
        int columns = tcm.getColumnCount();

        for (int i = 0; i < columns; i++) {
            JTextField textField = (JTextField) filterRow.getComponent(i);
            Dimension d = textField.getPreferredSize();
            d.width = tcm.getColumn(i).getWidth();
            textField.setPreferredSize(d);
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                filterRow.revalidate();
            }
        });
    }

    @Override
    public void columnMoved(TableColumnModelEvent e) {
        Component moved = filterRow.getComponent(e.getFromIndex());
        filterRow.remove(e.getFromIndex());
        filterRow.add(moved, e.getToIndex());
        filterRow.validate();
    }

    @Override
    public void columnAdded(TableColumnModelEvent e) {
    }

    @Override
    public void columnRemoved(TableColumnModelEvent e) {
    }

    @Override
    public void columnSelectionChanged(ListSelectionEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TableFilterRow frame = new TableFilterRow();
            }
        });
    }
}