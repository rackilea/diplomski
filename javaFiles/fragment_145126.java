import java.awt.Component;
import java.awt.EventQueue;
import java.util.EventObject;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;


public class JTableCellTest {
    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                Object[] columnNames = {"S.No", "Data"};
                Object[][] data = {
                                        {"1", "I'm going to create application in that to enter invoice i've created form in which i have used JTable but end user requirement is that the the description may be of 2 to 3 lines.\n I'm going to create application in that to enter invoice i've created form in which i have used JTable but end user requirement is that the the description may be of 2 to 3 lines. \n I'm going to create application in that to enter invoice i've created form in which i have used JTable but end user requirement is that the the description may be of 2 to 3 lines"},
                                        {"2", "I'm going to create application in that to enter invoice i've created form in which i have used JTable but end user requirement is that the the description may be of 2 to 3 lines.\n I'm going to create application in that to enter invoice i've created form in which i have used JTable but end user requirement is that the the description may be of 2 to 3 lines. \n I'm going to create application in that to enter invoice i've created form in which i have used JTable but end user requirement is that the the description may be of 2 to 3 lines"},
                                        {"3", "I'm going to create application in that to enter invoice i've created form in which i have used JTable but end user requirement is that the the description may be of 2 to 3 lines.\n I'm going to create application in that to enter invoice i've created form in which i have used JTable but end user requirement is that the the description may be of 2 to 3 lines. \n I'm going to create application in that to enter invoice i've created form in which i have used JTable but end user requirement is that the the description may be of 2 to 3 lines"}
                                  };

                JFrame frame = new JFrame();
                JTable table = new JTable(data, columnNames);
                table.setRowHeight(70);

                table.getColumnModel().getColumn(1).setCellRenderer(new CustomCellRenderer());
                table.getColumnModel().getColumn(1).setCellEditor(new CustomEditor());

                frame.setTitle("JTable with JTextArea");
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setVisible(true);

            }
        };

        EventQueue.invokeLater(r);
    }
}

class CustomCellRenderer extends DefaultTableCellRenderer {

        private JTextArea textArea;
        private JScrollPane scrollPane;

        public CustomCellRenderer() {
            textArea = new JTextArea();
            scrollPane = new JScrollPane(textArea);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            if(null != value)
                textArea.setText(value.toString());

            return scrollPane;
        }
}

class CustomEditor implements TableCellEditor {

    private JTextArea textArea;
    private JScrollPane scrollPane;

    public CustomEditor() {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if(null != value)
            textArea.setText(value.toString());

        return scrollPane;
    }

    @Override
    public void addCellEditorListener(CellEditorListener arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public void cancelCellEditing() {
        // TODO Auto-generated method stub

    }
    @Override
    public Object getCellEditorValue() {
        // TODO Auto-generated method stub
        return textArea.getText();
    }
    @Override
    public boolean isCellEditable(EventObject arg0) {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public void removeCellEditorListener(CellEditorListener arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean shouldSelectCell(EventObject arg0) {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public boolean stopCellEditing() {
        // TODO Auto-generated method stub
        return true;
    }
}