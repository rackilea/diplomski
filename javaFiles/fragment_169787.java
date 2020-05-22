import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;

class BiogramTable extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JCheckBox checkbox;
    private static final long serialVersionUID = 1L;

    /**
     * Create the frame.
     */
    public BiogramTable() {
        Object[] columns = {"Name", "Age", "Gender", "Boolean"};

        Object[][] data = {{"John", "18", "Male", false},
        {"Jessica", "19", "Female", false},
        {"Dave", "52", "Male", false},
        {"Jake", "30", "Male", false},
        {"Jeremy", "14", "Male", false},
        {"Jemma", "34", "Female", false},
        {"Amy", "16", "Female", false},
        {"Patrick", "18", "Male", false}};
        DefaultTableModel model = new DefaultTableModel(data, columns);
        final JCheckBox checkBox = new JCheckBox();

        table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    case 1:
                        return Integer.class;
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    default:
                        return String.class;
                }
            }
        };

        //table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                BiogramTable frame = new BiogramTable();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocation(150, 150);
                frame.setVisible(true);
            }

        });
    }
}