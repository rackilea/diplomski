import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Example extends JFrame {

    private final JTable table;
    private final String[] header = new String[]{"Column 0", "Column 1", "Column 2", "Column 3"};
    private String[][] data = new String[][]{
        {"(0,0)", "(1,0)", "(2,0)", "(3,0)"},
        {"(0,1)", "(1,1)", "(2,1)", "(3,1)"},
        {"(0,2)", "(1,2)", "(2,2)", "(3,2)"},
        {"(0,3)", "(1,3)", "(2,3)", "(3,3)"}};
    private final Font tableFont = new Font("Lucida Console", Font.PLAIN, 18);

    public Example() {
        table = new JTable(data, header);
        table.getTableHeader().setFont(tableFont);//font of the header
        table.setFont(tableFont);//set the font of the whole table

        //Since each cell is editable, you could think about it as a JTextField. You can create a
        //new JTextField and customize it. Then, you pass it as the new cell editor to the columns
        //of the JTable.
        JTextField textField = new JTextField();
        textField.setFont(tableFont);//this is what you need.
        //Extra changes, no boarder and selection colour is yellow... just to get the point across.
        textField.setBorder(null);
        textField.setSelectionColor(Color.YELLOW);

        //Create DefaultCellEditor and pass the textfield to the constructor.
        DefaultCellEditor customCellEditor = new DefaultCellEditor(textField);
        //Loop through all the columns and set the cell editor as the customized one.
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellEditor(customCellEditor);
        }
        /*
        OR, don't create a JTextField and use the following instead:
        DefaultCellEditor customCellEditor2 = new DefaultCellEditor(new JTextField()) {

            @Override
            public java.awt.Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
                JTextField result = (JTextField) super.getTableCellEditorComponent(table, value,
                    isSelected, row, column);
                result.setFont(tableFont);//this is what you need.
                result.setBorder(null);
                result.setSelectionColor(Color.YELLOW);
                return result;
            }
        };

        //Loop through all the columns and set the cell editor as the customized one.
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellEditor(customCellEditor2);
        }
         */

        //probably, you should make the height of the cells larger.
        for (int i = 0; i < table.getRowCount(); i++) {
            table.setRowHeight(i, 25);
        }

        add(new JScrollPane(table));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }