import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

public class EachRowTableEditorExample extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;

    public EachRowTableEditorExample() {
        super("EachRow Editor Example");
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        DefaultTableModel dm = new DefaultTableModel() {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                int modelColumn = table.convertColumnIndexToModel(column);
                return (modelColumn == 2) ? false : true;
            }
        };
        dm.setDataVector(new Object[][]{
                    {new Double(0), new Integer(2), new Double(0.0)},
                    {new Double(0), new Integer(6), new Double(0.0)},
                    {new Double(0), new Integer(11), new Double(0.0)},
                    {new Double(0), new Integer(5), new Double(0.0)},
                    {new Double(0), new Integer(30), new Double(0.0)}},
                new Object[]{"Combos", "Amount", "Running Total"});
        dm.addTableModelListener(new MyTableModelListener());
        table = new JTable(dm);
        table.setRowHeight(20);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem(new Double(0.00));
        comboBox.addItem(new Double(100.00));
        comboBox.addItem(new Double(200.00));
        comboBox.addItem(new Double(300.00));
        JComboBox comboBox1 = new JComboBox();
        comboBox1.addItem(new Double(0.00));
        comboBox1.addItem(new Double(-15.00));
        comboBox1.addItem(new Double(-25.00));
        comboBox1.addItem(new Double(35.00));
        JComboBox comboBox2 = new JComboBox();
        comboBox2.addItem(new Double(0.00));
        comboBox2.addItem(new Double(40.00));
        comboBox2.addItem(new Double(-15.00));
        comboBox2.addItem(new Double(10.00));
        JComboBox comboBox3 = new JComboBox();
        comboBox3.addItem(new Double(0.00));
        comboBox3.addItem(new Double(10.00));
        comboBox3.addItem(new Double(35.00));
        comboBox3.addItem(new Double(20.00));
        JComboBox comboBox4 = new JComboBox();
        comboBox4.addItem(new Double(0.00));
        comboBox4.addItem(new Double(-20.00));
        comboBox4.addItem(new Double(-10.00));
        comboBox4.addItem(new Double(15.00));
        EachRowEditor rowEditor = new EachRowEditor(table);
        rowEditor.setEditorAt(0, new DefaultCellEditor(comboBox));
        rowEditor.setEditorAt(1, new DefaultCellEditor(comboBox1));
        rowEditor.setEditorAt(2, new DefaultCellEditor(comboBox2));
        rowEditor.setEditorAt(3, new DefaultCellEditor(comboBox3));
        rowEditor.setEditorAt(4, new DefaultCellEditor(comboBox4));
        table.getColumn("Combos").setCellEditor(rowEditor);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scroll = new JScrollPane(table);
        getContentPane().add(scroll, BorderLayout.CENTER);
        setLocation(150, 100);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        EachRowTableEditorExample frame = new EachRowTableEditorExample();
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    class MyTableModelListener implements TableModelListener {

        public void tableChanged(TableModelEvent e) {
            System.out.println(e.getSource());
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 0 || column == 1) {
                    TableModel model = table.getModel();
                    int quantity = ((Integer) model.getValueAt(row, 1)).intValue();
                    double price = ((Double) model.getValueAt(row, 0)).doubleValue();
                    Double value = new Double(quantity * price);
                    model.setValueAt(value, row, 2);
                }
            }
        }
    }

    class EachRowEditor implements TableCellEditor {

        private Hashtable editors;
        private TableCellEditor editor, defaultEditor;
        private JTable table;

        /**
         * Constructs a EachRowEditor. create default editor
         *
         * @see TableCellEditor
         * @see DefaultCellEditor
         */
        public EachRowEditor(JTable table) {
            this.table = table;
            editors = new Hashtable();
            defaultEditor = new DefaultCellEditor(new JTextField());
        }

        /**
         * @param row
         *            table row
         * @param editor
         *            table cell editor
         */
        public void setEditorAt(int row, TableCellEditor editor) {
            editors.put(new Integer(row), editor);
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            //editor = (TableCellEditor)editors.get(new Integer(row));
            //if (editor == null) {
            //  editor = defaultEditor;
            //}
            return editor.getTableCellEditorComponent(table, value, isSelected,
                    row, column);
        }

        public Object getCellEditorValue() {
            return editor.getCellEditorValue();
        }

        public boolean stopCellEditing() {
            return editor.stopCellEditing();
        }

        public void cancelCellEditing() {
            editor.cancelCellEditing();
        }

        public boolean isCellEditable(EventObject anEvent) {
            selectEditor((MouseEvent) anEvent);
            return editor.isCellEditable(anEvent);
        }

        public void addCellEditorListener(CellEditorListener l) {
            editor.addCellEditorListener(l);
        }

        public void removeCellEditorListener(CellEditorListener l) {
            editor.removeCellEditorListener(l);
        }

        public boolean shouldSelectCell(EventObject anEvent) {
            selectEditor((MouseEvent) anEvent);
            return editor.shouldSelectCell(anEvent);
        }

        protected void selectEditor(MouseEvent e) {
            int row;
            if (e == null) {
                row = table.getSelectionModel().getAnchorSelectionIndex();
            } else {
                row = table.rowAtPoint(e.getPoint());
            }
            editor = (TableCellEditor) editors.get(new Integer(row));
            if (editor == null) {
                editor = defaultEditor;
            }
        }
    }
}