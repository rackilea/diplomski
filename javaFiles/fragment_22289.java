//This is the code which I have used to change jtable cell background color dynamically
[green color indicates empty(free) cell and red color indicates occupied cells][1]
 int row, col, row1, column;
    TableCellRenderer renderer;
    private static final int STATUS_COL = 1;
String host = "jdbc:mysql://localhost/your_database";
        String username = "root";
        String password = "";
        Statement stmt = null;
try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection(host, username, password);
            stmt = connect.createStatement();
            String sql = "your query";
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            Object[][] data = new Object[10][2];
            DefaultTableModel model = new DefaultTableModel(data, col);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            rs = stmt.executeQuery(sql);
 int rowCnt = 0;
              try{

       rs = stmt.executeQuery(sql);
       if(rs.last()){
           rowCnt = rs.getRow();
       } 
    } catch (Exception e){
       System.out.println("Error getting row count");
       e.printStackTrace();
    }

            int nCol = rs.getMetaData().getColumnCount();
            List<String[]> table = new ArrayList<>();
String[] row = new String[nCol];
for(int l=1; l<rowCnt; l++)
{
    for (int iCol = 1; iCol <= nCol; iCol++) {
                    Object obj = rs.getObject(iCol);
                    row[iCol - 1] = (obj == null) ? null : obj.toString();
jTable1.setDefaultRenderer(Object.class, new EntryCellRender());
 }
                table.add(row);
}
 } catch (Exception e) {
            System.out.println(e);
        }
    }
public class EntryCellRender extends DefaultTableCellRenderer {

    private final Color alt2 = Color.RED;
    private final Color alt1 = Color.GREEN;
    private final Color invalidStatus = Color.RED;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cr = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
if ("".equals(table.getValueAt(row, col))) {
             setBackground(alt1);
           } else {
               setBackground(alt2);
           }

        return cr;
    }

    private Color colorAlternator(int row) {
        if ((row % 2) == 0) {
            return alt1;
        } else {
            return alt2;
        }
    }
}   

    enter code here

  [1]: https://i.stack.imgur.com/Fi4LF.png