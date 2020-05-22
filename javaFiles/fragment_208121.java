import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class ColoringCells {

    private static Object[] columnName = {"Yes", "No"};
    private static Object[][] data = {
            {"Y", "N"},
            {"N", "Y"},
            {"Y", "N"}
    };


    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {

                JFrame frame = new JFrame();
                JTable table = new JTable(data, columnName);
                table.getColumnModel().getColumn(0).setCellRenderer(new CustomRenderer());
                table.getColumnModel().getColumn(1).setCellRenderer(new CustomRenderer());

                frame.add(new JScrollPane(table));
                frame.setTitle("Rendering in JTable");
                frame.pack();
                frame.setVisible(true);
            }
        };

        EventQueue.invokeLater(r);
    }
}


class CustomRenderer extends DefaultTableCellRenderer 
{
private static final long serialVersionUID = 6703872492730589499L;

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if(table.getValueAt(row, column).equals("Y")){
            cellComponent.setBackground(Color.YELLOW);
        } else if(table.getValueAt(row, column).equals("N")){
            cellComponent.setBackground(Color.GRAY);
        }
        return cellComponent;
    }
}