import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class TestTable5 {

    public TestTable5() {
        String blah = "pee#skillet#assassin$pee#skillet#stackoverflow";
        String[] colNames = {"name", "surname", "job"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable table = new JTable(model);

        String[] lines = blah.split("\\$");   // escape the $
        for (String line : lines) {
            model.addRow(line.split("#"));
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestTable5();
            }
        });
    }
}