PreparedStatement buyquery=connection.prepareStatement("Select * from Buy;");
rs=buyquery.executeQuery();
if (rs.next())
{
    Pname=rs.getString("ProductName");
}