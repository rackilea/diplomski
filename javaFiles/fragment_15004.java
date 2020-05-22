import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestTable {
    String[] cols = {"Col 1", "Col 2", "Col 3", "Col 4", "Col 5", "Col 6", "COl 7", "Col 8"};
    DefaultTableModel model = new DefaultTableModel(cols, 0);
    JTable table = new JTable(model);
    JButton button = new JButton("Set Table");
    List<Product> list;

    public TestTable() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        list = getOneRow();

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for (Product p : list) {
                    String data1 = p.field1;
                    int data2 = p.field2;
                    int data3 = p.field3;
                    int data4 = p.field4;
                    int data5 = p.field5;
                    int data6 = p.field6;
                    int data7 = p.field7;
                    int data8 = p.field8;

                    Object[] row = {data1, data2, data3, data4, data5, data6, data7, data8};
                    model.addRow(row);

                }
            }
        });

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public List<Product> getOneRow() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Product 1", 1, 2, 3, 4, 5, 6, 7));
        list.add(new Product("Product 2", 1, 2, 3, 4, 5, 6, 7));
        list.add(new Product("Product 3", 1, 2, 3, 4, 5, 6, 7));
        list.add(new Product("Product 4", 1, 2, 3, 4, 5, 6, 7));


        return list;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               new TestTable();
            }
        });
    }
}

class Product {
    String field1;
    int field2;
    int field3;
    int field4;
    int field5;
    int field6;
    int field7;
    int field8;

    public Product(String s, int f2, int f3, int f4, int f5, int f6, int f7, int f8) {
        field1 = s;
        field2 = f2;
        field3 = f3;
        field4 = f4;
        field5 = f5;
        field6 = f6;
        field7 = f7;
        field8 = f8;

    }  
}