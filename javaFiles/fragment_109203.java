import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class TestTableKeyBinding extends JFrame {

    private JTable table;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TestTableKeyBinding test = new TestTableKeyBinding();
                test.setVisible(true);
            }
        });
    }

    TestTableKeyBinding() {
        super();
        initUI();
        addKeyBindings();
    }

    private void initUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] headers = new String[] { "apples", "bananas" };
        String[][] data = new String[][] { { "1", "2" }, { "4", "6" }, { "5", "7" }, { "1", "3" },
                { "2", "11" } };
        table = new JTable(new DefaultTableModel(data,headers));
        table.setRowSelectionAllowed(true);
        this.add(new JScrollPane(table));
        this.pack();
        this.setSize(new Dimension(300, 400));

    }

    private void addKeyBindings() {
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
        table.getActionMap().put("save", saveAction());
        table.getInputMap(JComponent.WHEN_FOCUSED).put(keyStroke, "save");
    }

    private AbstractAction saveAction() {
        AbstractAction save = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(TestTableKeyBinding.this.table, "Action Triggered.");
                table.editingCanceled(null);
                table.editingStopped(null);
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
                }
            }
        };
        return save;
    }
}