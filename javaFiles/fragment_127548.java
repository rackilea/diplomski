Connection c = DBconnect.connect();
Statement s = c.createStatement();
String e = txtempId.getText();
ResultSet rs = s.executeQuery("SELECT * FROM nonacademic WHERE empId='" +e+ "'");
if(rs.next())
{
     do
     {
         // If there is data, then process it
     }
     while(rs.next());
}
else
    System.out.println("Not Found");