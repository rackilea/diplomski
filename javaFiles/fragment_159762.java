public class MyModel extends AbstractTableModel {

    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public MyModel () {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename?useUnicode=true&characterEncoding=UTF-8",
                        "root", "password");
                stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery("select * from tablename");

            } catch (SQLException e) {
                String msg = "MyModel(): Error Connecting to Database:\n"
                        + e.getMessage();
                System.out.println(msg);
            }
        } catch (ClassNotFoundException e) {
            String msg = "The com.mysql.jdbc.Driver is missing\n"
                    + "install and rerun the application";
            System.out.println(msg);
            System.exit(1);
        } finally {

        }
    }

    public int getRowCount() {
// count your rows and return 
        return count;
    }

    public int getColumnCount() {
// how many cols will you need goes here
        return 3;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rs.absolute(rowIndex + 1);
            switch (columnIndex) {
                case 0: 
                    return rs.getInt(1);
                case 1:
                    return rs.getString(2);
                case 2:
                    return rs.getString(6);
                default:
                    return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}