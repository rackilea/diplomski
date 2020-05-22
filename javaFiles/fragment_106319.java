import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class TableDemo {

    public static void main(String[] args) {
        final Vector<String> values = new Vector<String>();
        values.add("Val1");
        values.add("Val2");
        final JTable table = new JTable(new Object[][] { { "key", values },
                { "key2", values } }, new String[] { "Col1", "Col2" });

        table.getColumnModel().getColumn(1).setCellRenderer(new MyTableCellRenderer());
        table.registerKeyboardAction(new CopyAction(), KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_FOCUSED);
        table.setCellSelectionEnabled(true);
        final JFrame jf = new JFrame();
        jf.getContentPane().add(table);

        jf.setSize(500, 500);

        jf.setVisible(true);
    }

    private static class CopyAction extends AbstractAction {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            final JTable tbl = (JTable) e.getSource();
            final int row = tbl.getSelectedRow();
            final int col = tbl.getSelectedColumn();
            if (row >= 0 && col >= 0) {
                final TableCellRenderer renderer = tbl.getCellRenderer(row, col);
                final Component comp = tbl.prepareRenderer(renderer, row, col);
                if (comp instanceof JLabel) {
                    final String toCopy = ((JLabel) comp).getText();
                    final StringSelection selection = new StringSelection(toCopy);
                    final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(selection, selection);
                }
            }
        }

    }
}

@SuppressWarnings("serial")
class MyTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);

        @SuppressWarnings("unchecked")
        final
        Vector<String> values = (Vector<String>) value;
        setText(values.get(row));

        return this;
    }
}