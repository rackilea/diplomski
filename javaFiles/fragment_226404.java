import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;

public class TableCheckBox extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;

    public TableCheckBox() {

        setLayout(new GridLayout(2,1));

        Object[] columnNames = {"Check"};
        Object[][] data = { {false}, {false}, {false}, {false} };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model) {
            private static final long serialVersionUID = 1L;
            @Override
            public Class getColumnClass(int column) {
                return Boolean.class;
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        JButton btn = new JButton("Check All");
        btn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                for (int row=0; row < table.getRowCount(); row++) {
                    table.setValueAt(true, row, 0);
                }
            } 
        } );
        add(btn);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TableCheckBox frame = new TableCheckBox();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocation(150, 150);
                frame.setVisible(true);
            }
        });
    }
}