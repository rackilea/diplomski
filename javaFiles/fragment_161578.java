public int insertUpdateLeaves(String employeeId,String date,String hours,String aLeave, String sLeave)
{
  Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_system", "root", ""); 
  con.setAutoCommit(false);
//When you set the autoCommit to false, it means no SQL statement is committed, unless you call it explicitly.



// Make two Prepared Statements one for Insert and another for Update
            PreparedStatement ps = con.prepareStatement("INSERT INTO payroll_system.monthly_timesheet(employeeID, Date, Hours, AnnualLeave, SickLeave) values (?,?,?,?,?)");
     String updateLeaveSQL=""; //Your Update query would be here
            PreparedStatement ps1 = con.prepareStatement(updateLeaveSQL);

//First run your insert statement
 ps.setString(1, employee_id);
            ps.setString(2, date);
            ps.setString(3, hours);
            ps.setString(4, ALeave);
            ps.setString(5, SLeave);
            int count = ps.executeUpdate(); 

//Since you need the existing Annual Leaves in your Leave_Remaining table, use a select Query to get the existing ones

int existingAnnualLeaves=<Value you get from Leave_Remaining Table>;

//Now update with existing Leaves
 existingAnnualLeaves=existingAnnualLeaves-ALeave;

//Run your update Query setting existingAnnualLeaves with this value
//Once you are finished with both insert and update call autoCommit.
            con.commit();






);

}