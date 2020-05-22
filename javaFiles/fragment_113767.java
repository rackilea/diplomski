public class d10 extends JFrame {

DefaultTableModel tableModel = new DefaultTableModel();
Vector<Vector<Object>> doubleVector = new Vector<>();
Vector<Object> singleVector = new Vector<>();
Vector<Object> ColumnNames = new Vector<>();
Connection con = null;
ResultSet rs = null;
PreparedStatement ps = null;
static String dbUrl = "jdbc:mysql://localhost/mydb";
public JTable table;

public static Connection connectToDb() throws ClassNotFoundException, SQLException {
    return DriverManager.getConnection(dbUrl, "root", "2323");
}

public d10() {
    try {
        con = connectToDb();
        ps = con.prepareStatement("select * from mytable");
        rs = ps.executeQuery();

        doubleVector = new Vector<>();
        while (rs.next()) {
            singleVector = new Vector<>();
            singleVector.add(rs.getInt(1));
            singleVector.add(rs.getString(2));
            doubleVector.add(singleVector);
        }
        ColumnNames = new Vector<>();
        ColumnNames.add("ID1");
        ColumnNames.add("Name1");

        tableModel = new DefaultTableModel(doubleVector, ColumnNames);
        table = new JTable(tableModel);

        add(new JScrollPane(table), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocation(400, 120);
        setVisible(true);

    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    } catch (SQLException sqle) {
        sqle.printStackTrace();
    }
}