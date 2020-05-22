import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TableCellEditor {

    public static void main(String[] args) {
        new TableCellEditor();
    }

    public TableCellEditor() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                List<List<String>> values = new ArrayList<>(25);
                for (int row = 0; row < 10; row++) {

                    List<String> rowValues = new ArrayList<>(25);
                    for (int index = 0; index < 10; index++) {
                        rowValues.add("Value " + index + " for row " + row);
                    }
                    values.add(rowValues);

                }

                DefaultTableModel model = new DefaultTableModel(new Object[]{"Data"}, 10);
                JTable table = new JTable(model);
                table.setShowGrid(true);
                table.setGridColor(Color.GRAY);
                table.getColumnModel().getColumn(0).setCellEditor(new MyEditor(values));

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class MyEditor extends DefaultCellEditor {

        private List<List<String>> rowValues;

        public MyEditor(List<List<String>> rowValues) {
            super(new JComboBox());
            this.rowValues = rowValues;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

            JComboBox cb = (JComboBox) getComponent();
            List<String> values = rowValues.get(row);
            DefaultComboBoxModel model = new DefaultComboBoxModel(values.toArray(new String[values.size()]));
            cb.setModel(model);

            return super.getTableCellEditorComponent(table, value, isSelected, row, column);

        }

    }

}