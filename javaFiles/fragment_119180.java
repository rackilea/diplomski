import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import net.proteanit.sql.DbUtils;

public class SearchResult {
JFrame frame, frame1; 
JPanel panel;
static JTable table;

String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
String url = "jdbc:sqlserver://localhost;instance=DESKTOP-8QFTIP4;databaseName=deneme;user=sa;password=******";
String userName = "sa";
String password = "*****";    

public void createUI()
{
    showTableData();
} 
public void showTableData()
{

    frame1 = new JFrame("Database Search Result");
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame1.setLayout(new BorderLayout()); 
    table = new JTable(); 
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    table.setFillsViewportHeight(true);
    JScrollPane scroll = new JScrollPane(table);
    scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
    try
    {
        Class.forName(driverName);
        System.out.println("conn before");
        Connection con = DriverManager.getConnection(url, userName, password);
        System.out.println("conn after");
        String sql ="Select EmpDetails_ID, First_Name, Last_Name, Gender, Position_ID, "
                + " employee_details.Department_ID,department.Department_Name , Office_Location_ID, Employee_Status, "
                + " Office_Number, Mobile_Number, Email_Address, Remarks, Image "
                + " From employee_details inner join department on employee_details.Department_ID = department.Department_ID";
        PreparedStatement ps = con.prepareStatement(sql);
        System.out.println("about to execute");
        ResultSet rs = ps.executeQuery();
        int i =0;
        System.out.println("after to execute"); 
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }
    catch(Exception ex)
    {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
                JOptionPane.ERROR_MESSAGE);
    }
    frame1.add(scroll);
    frame1.setVisible(true);
    frame1.setSize(400,300);
}

public static void main(String args[])
{
    SearchResult sr = new SearchResult();
    sr.createUI();
}
}