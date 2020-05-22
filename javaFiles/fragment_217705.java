// the second parameter tells the driver 
// that you want the generated value for the column D_ID
PreparedStatement ps = con.prepareStatement(sqlqry, new String[]{"D_ID"});

// as before
ps.setInt(1,dto.getInstall_id());
ps.setString(2, dto.getDashboard_name());
... more parameters ...
ps.executeUpdate();

// now retrieve the generated ID
int d_id = -1;
ResultSet rs = ps.getGeneratedKeys();
if (rs.next()) // important!
{
   d_id = rs.getInt(1);
}
rs.close();