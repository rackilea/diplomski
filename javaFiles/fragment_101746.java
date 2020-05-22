import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;

public class TestTableModel {
   public static void main(String[] args) {
      BirthTableModel2 dm2 = new BirthTableModel2();
      JTable table = new JTable(dm2);
      JOptionPane.showMessageDialog(null, new JScrollPane(table));

      dm2.reloadBirthJTable();
      JOptionPane.showMessageDialog(null, new JScrollPane(table));
   }

}


// I had to guess at this class
class Birth {
   private Date date;
   private String children;
   private String comments;

   public Birth(Date date, String children, String comments) {
      this.date = date;
      this.children = children;
      this.comments = comments;
   }

   public Date getDate() {
      return date;
   }

   public String getChildren() {
      return children;
   }

   public String getComments() {
      return comments;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public void setChildren(String children) {
      this.children = children;
   }

   public void setComments(String comments) {
      this.comments = comments;
   }

}

@SuppressWarnings("serial")
class BirthTableModel2 extends AbstractTableModel {
   public final static String[] COLUMN_NAMES = { "Date", "Children",
   "Complications/Comments" }; // column header labels
   private List<Birth> birthList = new ArrayList<>();

   @Override
   public Class<?> getColumnClass(int columnIndex) {
      if (columnIndex == 0) {
         return Date.class;
      }
      return super.getColumnClass(columnIndex);
   }

   @Override
   public int getColumnCount() {
      return COLUMN_NAMES.length;
   }

   @Override
   public String getColumnName(int column) {
      return COLUMN_NAMES[column];
   }

   @Override
   public int getRowCount() {
      return birthList.size();
   }

   public void reloadBirthJTable() {
      System.out.println("loading birth table..");
      clearModel();
      for (int i = 0; i < 20; i++) {
         addRow();
      }
   }

   public void clearModel() {
      birthList.clear();
      fireTableDataChanged();
   }

   public void addRow() {
      birthList.add(new Birth(null, "", ""));
      fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
   }

   @Override
   public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
   }

   @Override
   public Object getValueAt(int rowIndex, int colIndex) {
      if (rowIndex < 0 || rowIndex >= getRowCount()) {
         // throw exception
      }
      if (colIndex < 0 || colIndex >= getColumnCount()) {
         // throw exception
      }
      Birth birth = birthList.get(rowIndex);
      switch (colIndex) {
      case 0:
         return birth.getDate();

      case 1:
         return birth.getChildren();

      case 2:
         return birth.getComments();
      }
      return null;
   }

   @Override
   public void setValueAt(Object aValue, int rowIndex, int colIndex) {
      if (rowIndex < 0 || rowIndex >= getRowCount()) {
         // throw exception
      }
      if (colIndex < 0 || colIndex >= getColumnCount()) {
         // throw exception
      }

      Birth birth = birthList.get(rowIndex);
      switch (colIndex) {
      case 0:
         birth.setDate((Date)aValue);
         break;
      case 1:
         birth.setChildren(aValue.toString());
         break;
      case 2:
         birth.setComments(aValue.toString());
      }
      fireTableRowsUpdated(rowIndex, rowIndex);

   }
}