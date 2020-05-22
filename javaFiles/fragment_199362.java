String sql= "insert into table1 (name, phone, bday, lastasked) values (?,?,?,now())";
PreparedStatenent pst = con.prepareStatement(sql);
pst.setString(1, "Stacy");
pst.setString(2, "555-0123456");
pst.setString(3, bdayFromInput);
pst.execute();