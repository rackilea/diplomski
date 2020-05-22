import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class Example {

    public static void main(String[] args) {
        new Example();
    }

    public Example() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private final JTable signalTable;

        public TestPane() {
            signalTable = new JTable();
    signalTable.setModel(new DefaultTableModel(
            new Object[][]{
                {"AAA", "A_SIGNAL", false, false, false, false, false, false, false, false, "Example", Boolean.TRUE},},
            new String[]{
                "ID", "Message Identifier", "0", "1", "2", "3", "4", "5", "6", "7", "Description", ""
            }
    ) {
        Class[] columnTypes = new Class[]{
            String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class, Boolean.class
        };

        public Class getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }
    });
            TableColorRenderer renderer = new TableColorRenderer();
            signalTable.getColumn("0").setCellRenderer(renderer);
            signalTable.getColumn("1").setCellRenderer(renderer);
            signalTable.getColumn("2").setCellRenderer(renderer);
            signalTable.getColumn("3").setCellRenderer(renderer);
            signalTable.getColumn("4").setCellRenderer(renderer);
            signalTable.getColumn("5").setCellRenderer(renderer);
            signalTable.getColumn("6").setCellRenderer(renderer);
            signalTable.getColumn("7").setCellRenderer(renderer);
            signalTable.getColumn("0").setCellEditor(new ButtonEditor());
            signalTable.getColumn("1").setCellEditor(new ButtonEditor());
            signalTable.getColumn("2").setCellEditor(new ButtonEditor());
            signalTable.getColumn("3").setCellEditor(new ButtonEditor());
            signalTable.getColumn("4").setCellEditor(new ButtonEditor());
            signalTable.getColumn("5").setCellEditor(new ButtonEditor());
            signalTable.getColumn("6").setCellEditor(new ButtonEditor());
            signalTable.getColumn("7").setCellEditor(new ButtonEditor());

            setLayout(new BorderLayout());
            add(new JScrollPane(signalTable));
        }

    }

    public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

        private JLabel editor;

        public ButtonEditor() {
            editor = new JLabel();
            editor.setBackground(Color.GREEN);

            editor.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    editor.setOpaque(!editor.isOpaque());
                    stopCellEditing();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value instanceof Boolean) {
                boolean result = (boolean) value;
                editor.setOpaque(!result);
            }
            return editor;
        }

        @Override
        public Object getCellEditorValue() {
            return editor.isOpaque();
        }

        @Override
        public boolean isCellEditable(EventObject e) {
            return true;
        }

    }

    public class TableColorRenderer extends JLabel implements TableCellRenderer {

        public TableColorRenderer() {
            setBackground(Color.GREEN);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Boolean) {
                boolean result = (boolean) value;
                setOpaque(result);
            }
            return this;
        }
    }
}