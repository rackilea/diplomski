import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableTest {

    public static void main(String[] args) throws InterruptedException {
        JFrame f = new JFrame();

        DefaultTableModel m = new DefaultTableModel();
        JTable t = new JTable(m);

        f.add(new JScrollPane(t), BorderLayout.CENTER);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        m.addColumn("A");
        m.addRow(new String[]{"A1"});

        Thread.sleep(1000);

        m.addColumn("B");
        m.addRow(new String[]{"A2", "B2"});     
    }
}