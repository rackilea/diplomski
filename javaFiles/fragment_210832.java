import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestJTableInsert {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final DefaultTableModel model = new DefaultTableModel(0, 1);
                new Timer(500, new ActionListener() {
                    private final Random random = new Random();
                    private int data = 1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.insertRow(random.nextInt(model.getRowCount() + 1),
                                new Object[] { data++ });
                    }
                }).start();

                final JTable table = new JTable(model);
                JPopupMenu popup = new JPopupMenu();
                popup.add(new AbstractAction("Which row is this?") {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(table,
                                "This is row " + table.getValueAt(table.getSelectedRow(), 0));
                    }
                });
                table.setComponentPopupMenu(popup);
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}