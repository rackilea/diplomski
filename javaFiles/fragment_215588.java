import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");

        Container cont = frame.getContentPane();
        cont.setLayout(new BorderLayout());

        DefaultTableModel dtm = new DefaultTableModel(new Object[]{"Column 1","Column 2"}, 0);
        JTable table = new JTable(dtm);

        JScrollPane scroll = new JScrollPane(table);
        cont.add(scroll, BorderLayout.CENTER);

        dtm.addRow(new Object[]{"Value 1", "Value 2"});

        JButton add = new JButton("Add");
        cont.add(add, BorderLayout.NORTH);

        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dtm.addRow(new Object[]{"Another value", "Another value"});
            }
        });

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}