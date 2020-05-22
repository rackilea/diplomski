import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class LimitedTableCellEditor extends JPanel {

    public LimitedTableCellEditor() {
        super(new GridLayout(1, 0));

        String[] columnNames = {"", "Main Menu", "Sub Menu",};

        Object[][] data = {
            {0, "File", ""},
            {1, "", "New"},
            {1, "", "Save"},
            {1, "", "Close"},
            {0, "Edit", ""},
            {1, "", "Delete"},
            {1, "", "Format"},
            {0, "Project", ""},
            {1, "", "Create New"},
            {1, "", "Delete"},
            {1, "", "Build"},
            {1, "", "Properties"},};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(model) {
            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return Integer.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                boolean editable = false;
                if (column == 0) {
                    Object value = getValueAt(row, column);
                    if (value instanceof Integer) {
                        editable = ((int)value) != 0;
                    }
                }
                return editable;
            }
        };

        table.getColumnModel().getColumn(0).setMaxWidth(30);
        table.getColumnModel().getColumn(0).setCellRenderer(new ConditionalCheckBoxRenderer());
        table.getColumnModel().getColumn(1).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setMaxWidth(120);

        table.setPreferredScrollableViewportSize(new Dimension(250, 195));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("SimpleTableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        LimitedTableCellEditor newContentPane = new LimitedTableCellEditor();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static class ConditionalCheckBoxRenderer extends JPanel implements TableCellRenderer {

        private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
        private JCheckBox cb;

        public ConditionalCheckBoxRenderer() {
            setLayout(new GridBagLayout());
            setOpaque(false);
            cb = new JCheckBox();
            cb.setOpaque(false);
            cb.setContentAreaFilled(false);
            cb.setMargin(new Insets(0, 0, 0, 0));
            add(cb);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setOpaque(isSelected);
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
            }
            if (value instanceof Integer) {
                int state = (int) value;
                cb.setVisible(state != 0);
                cb.setSelected(state == 2);
            }
            if (hasFocus) {
                setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
            } else {
                setBorder(NO_FOCUS_BORDER);
            }
            return this;
        }
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}