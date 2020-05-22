import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class TestJScrollPaneWithList {

    public static void main(String[] args) {
        List<String[]> sqlTable = new ArrayList<String[]>();

        sqlTable.add(new String[] { "test1" });
        sqlTable.add(new String[] { "test2" });
        sqlTable.add(new String[] { "test3" });

        JFrame fr = new JFrame("Test)");

        JList list = new JList(sqlTable.toArray());
        list.setCellRenderer(new ListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String[] val = (String[]) value;
                return new JLabel(val[0]);
            }
        });
        JScrollPane listScrollPane = new JScrollPane(list);

        fr.add(listScrollPane);

        fr.setSize(100, 100);
        fr.setVisible(true);
    }

}