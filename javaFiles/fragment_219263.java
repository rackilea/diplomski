import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

public class JTableTest extends JFrame implements TableModel{

    Vector<Object[]> lines = new Vector<Object[]>();
    private String[] headers = {"String","Boolean"};

    public JTableTest(){
        for (int t = 0; t < 100; t++) lines.addElement(new Object[]{"Row "+t,Boolean.FALSE});
        JPanel p = (JPanel)getContentPane();
        p.setLayout(new BorderLayout());
        JTable table = new JTable();
        table.setDefaultRenderer(String.class, new MyRenderer());
        p.add(new JScrollPane(table));
        table.setModel(this);
        p.setPreferredSize(new Dimension(400,200));
        pack();
        setVisible(true);
    }
    public static void main(String[] args){
        new JTableTest();
    }
    @Override
    public int getRowCount() {
        return lines.size()+1;
    }
    @Override
    public int getColumnCount() {
        return headers.length;
    }
    @Override
    public String getColumnName(int columnIndex) {
        return headers[columnIndex];
    }
    @Override
    public Class<?> getColumnClass(int col) {
        if (col == 1) return Boolean.class;
        return String.class;
    }
    @Override
    public boolean isCellEditable(int row, int col) {
        return col==1;
    }
    @Override
    public Object getValueAt(int row, int col) {
        return lines.elementAt(row)[col];
    }
    @Override
    public void setValueAt(Object aValue, int row, int col) {
        lines.elementAt(row)[col] = aValue;
    }
    @Override
    public void addTableModelListener(TableModelListener l) {
    }
    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
    private class MyRenderer extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (lines.elementAt(row)[1] == Boolean.TRUE) c.setBackground(Color.orange);
            else c.setBackground(table.getBackground());
            table.repaint();
            return c;
        }
    }
}