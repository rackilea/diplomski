import java.awt.Component;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class TestFrame extends JFrame {

    private DefaultComboBoxModel<String> model;
    private Map<String, List<String>> keyVal;

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        keyVal = new HashMap<>();
        keyVal.put("1", Arrays.asList(new String[]{"a","b"}));
        keyVal.put("0", Arrays.asList(new String[]{"c","d"}));
        keyVal.put("2", Arrays.asList(new String[]{"e","f","g"}));
        JTable t = new JTable(3,3);
        t.getColumnModel().getColumn(0).setCellEditor(getEditor());
        add(new JScrollPane(t));
    }

    private TableCellEditor getEditor() {

        return new DefaultCellEditor(new JComboBox<String>(model = new DefaultComboBoxModel<String>())){
            @Override
            public Component getTableCellEditorComponent(JTable table,Object value, boolean isSelected, int row, int column) {
                model.removeAllElements();
                if(keyVal.containsKey(row+"")){
                    List<String> list = keyVal.get(row+"");
                    for(String s : list)
                        model.addElement(s);
                }
                return super.getTableCellEditorComponent(table, value, isSelected, row, column);
            }
        };
    }

    public static void main(String args[]) {
        new TestFrame();
    }

}