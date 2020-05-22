import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TestFrame extends JFrame {

    public static void main(String... s) {
        new TestFrame();
    }

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        String[] columnNames = {"Column 1", "Column 2"};  
        DefaultTableModel model = new DefaultTableModel(columnNames, 0){
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 0 ? Boolean.class : super.getColumnClass(columnIndex);
            }
        };  
        JTable table=new JTable(model );  

        for (int i =0;i<5;i++) {
            Object[]  rows = {Boolean.FALSE, i};  
            model.addRow( rows );
        }

        add(new JScrollPane(table));
    }
}