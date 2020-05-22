import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestTable {
    String[] cols = {"Col 1", "Col2"};
    String[][] data = {{"Hello", "World"},{"Hello", "World"}};
    DefaultTableModel model = new DefaultTableModel(data, cols);
    JTable table = new JTable(model);
    JButton button = new JButton("Set Value at 1, 1");
    JTextField text = new JTextField(20);

    public TestTable() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(table, BorderLayout.NORTH);
        panel.add(text, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String value = text.getText();
                model.setValueAt(value, 1, 1);
            }
        });

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               new TestTable();
            }
        });
    }
}