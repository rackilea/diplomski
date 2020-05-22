Connection conn = getSession().connection();
CallableStatment stat = conn.prepareCall("{CALL insertComm (?,?)}");
stat.setString(1, remitNo); // Assuming both parameters are String
stat.setString(2, opt);

stat.executeUpdate();
stat.close();