import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.TableCellRenderer;

public class Test {
public static void main(String[] args) throws Throwable {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }

    String[] columnNames = new String[]{"c1"};
    Object[][] data = new Object[4][1];
    data[0][0] = "First";
    data[1][0] = "Second";
    data[2][0] = "Third";
    data[3][0] = "Fourth";

    JTable table  = new JTable(data, columnNames){
        @Override
        public javax.swing.table.TableCellRenderer getCellRenderer(int row, int column) {
            final TableCellRenderer ori = super.getCellRenderer(row, column);
            final TableCellRenderer mine = new TableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = ori.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    JPanel p = new JPanel();
                    if(value == null){
                        value = "";
                    }
                    p.add(new JButton(value.toString()));
                    p.setBackground(new Color(c.getBackground().getRGB()));
                    return p;
                }
            };
            return mine;
        };
    };
    table.setRowHeight(50);
    JFrame f = new JFrame();
    f.add(table);
    f.setVisible(true);
    f.pack();
}
}