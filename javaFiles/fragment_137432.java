import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/** @see https://stackoverflow.com/q/9874664/230513 */
public class MyTable extends JFrame {

    private static final String show = "Show";
    private DefaultTableModel tmodel = new DefaultTableModel(
        new Object[][]{
            {"edit"}, {"any"}, {"cell"}, {"text"}, {"and"}, {"edit me"}},
        new Object[]{
            "Column 1"});
    private JTable table = new JTable(tmodel);
    private Action showAction = new ShowAction(show);
    private JButton jb = new JButton(showAction);

    public MyTable() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        table.putClientProperty("terminateEditOnFocusLost", true);
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        table.getInputMap(JTable.WHEN_FOCUSED).put(enter, show);
        table.getActionMap().put(show, showAction);
        add(new JScrollPane(table), BorderLayout.CENTER);
        table.setPreferredScrollableViewportSize(new Dimension(400, 200));
        JPanel panel = new JPanel();
        panel.add(jb);
        getRootPane().setDefaultButton(jb);
        add(panel, BorderLayout.SOUTH);
        pack();
    }

    private class ShowAction extends AbstractAction {

        private ShowAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (table.isEditing()) {
                table.getCellEditor().stopCellEditing();
            }
            int row = table.getSelectedRow();
            if (row > -1) {
                JOptionPane.showMessageDialog(
                    MyTable.this, table.getModel().getValueAt(row, 0));
            }
        }
    }

    public static void main(String arg[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MyTable().setVisible(true);
            }
        });
    }
}