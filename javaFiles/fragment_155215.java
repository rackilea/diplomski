import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

        private JTable table;
        private DefaultTableModel model;
        private JSpinner fldRows;
        private JSpinner fldColumns;

        public TestPane() {

            setLayout(new BorderLayout());

            fldRows = new JSpinner(new SpinnerNumberModel(1, 1, 999999, 1));
            fldColumns = new JSpinner(new SpinnerNumberModel(1, 1, 999999, 1));

            JPanel options = new JPanel(new GridBagLayout());
            options.add(new JLabel("Rows: "));
            options.add(fldRows);
            options.add(new JLabel("Columns: "));
            options.add(fldColumns);

            JButton update = new JButton("Update");
            options.add(update);

            update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rows = (int) fldRows.getValue();
                    int cols = (int) fldColumns.getValue();

                    // Dynamic master model...
//                  model.setRowCount(rows);
//                  model.setColumnCount(cols);

                    // Replace model
                    table.setModel(new DefaultTableModel(rows, cols));
                }
            });

            model = new DefaultTableModel();
            table = new JTable();
            add(new JScrollPane(table));
            add(options, BorderLayout.NORTH);

        }

    }

}