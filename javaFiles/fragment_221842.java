import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TableDemo extends JFrame {

    DefaultTableModel model;

    public TableDemo() {

        JButton btnNewButton = new JButton("Insert Data");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                model.setValueAt("Testing", 0, 0);
            }
        });
        getContentPane().add(btnNewButton, BorderLayout.NORTH);
    }
    JTable jTable1;

    public static void main(String... args) {

        TableDemo tableDemo = new TableDemo();
        tableDemo.pamnel();

        JFrame frame = new TableDemo();

    }

    public void initComponents() {
    }

    public void pamnel() {
        initComponents();
        String[] columnNames = { "", "", "", "", "", "", "", "", "", "", "", "" };

        String[][] data = { { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" },
                { "", "", "", "", "", "", "", "", "", "", "", "" } };
        model = new DefaultTableModel(data, columnNames);

        jTable1 = new JTable(model);

        getContentPane().add(new JScrollPane(jTable1));
        pack();
        setVisible(true);
    }
}