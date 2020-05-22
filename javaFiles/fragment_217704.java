// note that there is no placeholder for the D_ID column
// the value is taken directly from the sequence
String sqlqry = 
"insert into testatble (d_id, install_id, dashboard_name)  " + 
"values (seq_testatble_d_id.nextval, ?, ?)";

PreparedStatement ps = con.prepareStatement(sqlqry);
ps.setInt(1,dto.getInstall_id());
ps.setString(2, dto.getDashboard_name());
... more parameters ...
ps.executeUpdate();