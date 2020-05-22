import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TestPrint {

    public static void main(String[] args) {
        new TestPrint();
    }

    public TestPrint() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultTableModel model = new DefaultTableModel(0, 26);
                for (int row = 0; row < 26; row++) {
                    Vector data = new Vector(26);
                    for (int col = 0; col < 26; col++) {

                        String value = row + "x" + ((char) (col + 'A'));
                        data.add(value);

                    }
                    model.addRow(data);
                }

                JTable table = new JTable(model);

                JButton print = new JButton("Print");
                print.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            DefaultTableModel viewModel = (DefaultTableModel) table.getModel();
                            DefaultTableModel printModel = new DefaultTableModel(0, viewModel.getColumnCount());
                            for (int row : table.getSelectedRows()) {
                                printModel.addRow((Vector) viewModel.getDataVector().get(row));
                            }
                            JTable toPrint = new JTable(printModel);
                            toPrint.setSize(toPrint.getPreferredSize());
                            JTableHeader tableHeader = toPrint.getTableHeader();
                            tableHeader.setSize(tableHeader.getPreferredSize());
                            toPrint.print(JTable.PrintMode.FIT_WIDTH);
                        } catch (PrinterException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.add(print, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}