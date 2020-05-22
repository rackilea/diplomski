import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MyCellRenderer extends JTextPane implements TableCellRenderer {

Color highlightBackground = (Color) UIManager.get("Table.selectionBackground");

@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    setText((String) value);//or something in value, like value.getNote()...
    setSize(table.getColumnModel().getColumn(column).getWidth(),
            getPreferredSize().height);
    if (table.getRowHeight(row) != getPreferredSize().height) {
        table.setRowHeight(row, getPreferredSize().height);
    }
    if (table.isRowSelected(row)) {
        this.setBackground(highlightBackground);
    } else {
        this.setBackground(Color.WHITE);
    }

    //Added lines
    StyledDocument doc = this.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);
    //Added Lines

    return this;
}
}