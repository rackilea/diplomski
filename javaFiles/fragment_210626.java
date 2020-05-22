import java.awt.*;
import java.util.EventObject;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class SliderColumn extends AbstractCellEditor
    implements TableCellEditor, TableCellRenderer {

    private JSlider editSlider, renderSlider;
    private Border originalBorder;

    public SliderColumn(JTable table, int column) {
        editSlider = new JSlider();
        renderSlider = new JSlider();
        originalBorder = editSlider.getBorder();
        editSlider.setBorder(new LineBorder(Color.BLUE));
        table.getColumnModel().getColumn(column).setCellEditor(this);
        Dimension d = renderSlider.getPreferredSize();
        table.setRowHeight(d.height);
    }

    @Override
    public Object getCellEditorValue() {
        return editSlider.getValue();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) {
        if (value != null) {
            editSlider.setValue((Integer) value);
        }
        return editSlider;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        if (hasFocus) {
            renderSlider.setBorder(new LineBorder(Color.BLUE));
        } else {
            renderSlider.setBorder(originalBorder);
        }
        if (value == null) {
            renderSlider.setValue(0);
        } else {
            int intValue = ((Integer) value).intValue();
            renderSlider.setValue(intValue);
        }
        return renderSlider;
    }

    @Override
    public boolean isCellEditable(EventObject evt) {
        return true;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("SpinnerColumn");
                JPanel panel = new JPanel(new GridLayout(1, 1));
                JTable table = new JTable(5, 1);
                SliderColumn spinnerColumn = new SliderColumn(table, 0);
                table.setDefaultRenderer(Object.class, spinnerColumn);
                panel.add(table);
                frame.setContentPane(panel);
                frame.pack();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}