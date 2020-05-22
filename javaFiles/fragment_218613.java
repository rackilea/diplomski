import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TestTable2 {

    protected void initUI() {
        DefaultTableModel model = new DefaultTableModel();
        for (int i = 0; i < 5; i++) {
            model.addColumn("Col-" + (i + 1));
        }
        for (int i = 0; i < 200; i++) {
            Vector<Object> row = new Vector<Object>();
            for (int j = 0; j < 5; j++) {
                row.add("New cell - " + (j + 1));
            }
            model.addRow(row);
        }
        JTable table = new JTable(model);
        final JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(button, "You have clicked me");
            }
        });
        JTableHeader header = table.getTableHeader();
        header.setLayout(new FlowLayout(FlowLayout.TRAILING, 5, 0));
        header.add(button);
        JFrame frame = new JFrame(TestTable2.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scrollpane = new JScrollPane(table);
        frame.add(scrollpane, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable2().initUI();
            }
        });
    }

}