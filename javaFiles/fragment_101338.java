String sql="SELECT * FROM "+tesztvalt+""; 

PreparedStatement pst = conn.prepareStatement(sql);
ResultSet rs = pst.executeQuery();

while (rs.next()) 
{
    tabla.setModel(model);
}