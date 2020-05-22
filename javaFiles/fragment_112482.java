import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
        DefaultTableModel model = new DefaultTableModel(0,2);
        JTable t = new JTable(model);
        t.getColumnModel().getColumn(0).setCellRenderer(new ButtonCell());
        t.getColumnModel().getColumn(0).setCellEditor(new ButtonCell());
        ImageIcon icon = new ImageIcon(TestFrame.class.getResource("1.png"));
        model.addRow(new Object[]{icon,"test"});
        model.addRow(new Object[]{null,"test2"});
        model.addRow(new Object[]{icon,"test3"});

        add(new JScrollPane(t));
    }


    public static void main(String... s){
        new TestFrame();
    }

    private class ButtonCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{

        private JButton btn;

        ButtonCell(){
            btn = new JButton();
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("clicked");
                }
            });
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            if(value instanceof Icon){
                btn.setIcon((Icon) value);
            } else {
                btn.setIcon(null);
            }
            return btn;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            if(value instanceof Icon){
                btn.setIcon((Icon) value);
            } else {
                btn.setIcon(null);
            }
            return btn;
        }

    }

}