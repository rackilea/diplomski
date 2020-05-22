import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


public class TestFrame extends JFrame {

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        JTable t = new JTable(new DefaultTableModel(3,3){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(row == getRowCount()-1 && column != 0){
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        });
        t.setGridColor(t.getTableHeader().getBackground());
        add(new JScrollPane(t));
        for(int i=0;i<3;i++)
            t.getColumnModel().getColumn(i).setCellRenderer(getDummyRenderer());
        t.getColumnModel().getColumn(0).setCellEditor(getDummyEditor());
    }


    private TableCellEditor getDummyEditor() {
        return new DummyEditor();
    }

    private TableCellRenderer getDummyRenderer() {
        return new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                if(row == table.getRowCount()-1){
                    if(column == 0){
                        return new JButton("dummy");
                    } else {
                        JLabel jLabel = new JLabel("");
                        jLabel.setOpaque(true);
                        jLabel.setBorder(null);
                        return jLabel;
                    }
                } else {
                    Component tableCellRendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    return tableCellRendererComponent;
                }
            }
        };
    }

    public static void main(String args[]) {
        new TestFrame();
    }

    private class DummyEditor extends DefaultCellEditor implements TableCellEditor{

        private JButton btn = new JButton("dummy");

        public DummyEditor(){
            super(new JTextField());
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("clicked");
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            return row == table.getRowCount()-1 ? btn : super.getTableCellEditorComponent(table, value, isSelected, row, column);
        }

    }

}