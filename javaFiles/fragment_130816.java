public class MyTableModel extends DefaultTableModel {

 public MyTableModel(Vector data, Vector columnNames) {
    setDataVector(data, columnNames);
 }

 @Override
 public boolean isCellEditable(int row, int column) {
         return false;
     }
}