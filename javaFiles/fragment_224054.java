String sql="insert into std(ADM_NO,Form,Student,Parent,Contact) values(?,?,?,?,?)";
ps=conn.prepareStatement(sql);
ps.setString(1, txtadm.getText());
ps.setString(2, txtform.getText());
ps.setString(3, txtsname.getText());
ps.setString(4, txtpname.getText());
ps.setString(5, txtmobileno.getText());
ps.executeUpdate();