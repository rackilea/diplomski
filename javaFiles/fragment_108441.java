import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SimpleTable {
    public SimpleTable(){                                                                  
        JFrame f = new JFrame();
        Object[][] tableInputs = {
        { 
            "Customer1","0000001", "100.00",
        },
        { 
            "Customer2", "0000002", "200.00"
        },
        { 
            "Customer3", "0000003", "550.00"
        }};
        String[] header = { "NAME", "ACCOUNT", "BALANCE" };
        JTable table = new JTable(tableInputs, header);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        JScrollPane scrollPane = new JScrollPane(table);
        f.add(scrollPane);
        f.setTitle("Simple Table");
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        SimpleTable b = new SimpleTable();
    }
}