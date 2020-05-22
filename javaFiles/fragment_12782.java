import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import practice.Table.MyTableModel;

public class TestTable extends JFrame {

    private Table table1;
    private JButton button;
    public TestTable() {
        table1 = new Table();
        button = new JButton("Get Value at 0, 0");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = table1.getTable();
                MyTableModel model = (MyTableModel)table.getModel();
                System.out.println(model.getValueAt(0, 0));
            }
        });

        add(table1);
        add(button, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    } 

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new TestTable();
            }
        });
    }
}