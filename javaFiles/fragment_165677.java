import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer{
@Override
public Component getTableCellRendererComponent (JTable table, Object obj,
    boolean isSelected, boolean hasFocus, int row, int column) {
Component cell = super.getTableCellRendererComponent(
    table, obj, isSelected, hasFocus, row, column );

    //I USE THIS TO ACCESS THE DATA FROM ANOTHER CELL!!!
    TableModel model = table.getModel();
    String media= (String) model.getValueAt(row, 0)


    if (row % 2 == 0){
        cell.setFont(getFont().deriveFont(Font.BOLD));
    }


   //SO I GET THE RESULT I WANT
   if ("book".equals(media)){
     cell.setBackground(Color.red)  
   }
   else{
     cell.setBackground(Color.green)
   }  



    return cell;
}
}