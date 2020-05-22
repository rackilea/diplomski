import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Example extends JFrame {

    public static void main(String... s){
        new Example();
    }

    public Example(){
        DefaultTableModel model = new DefaultTableModel(4,4) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if(columnIndex == 3){
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };

        JTable t = new JTable(model);
        add(new JScrollPane(t));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}