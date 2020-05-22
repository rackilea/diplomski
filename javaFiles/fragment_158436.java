String insertSQL = "insert into info(name,email,age,dob) values(?,?,?,?)";
PreparedStatement ps = dbConnection.prepareStatement(insertSQL);
    ps.setString(1,name);
    ps.setString(2,email);
    ps.setString(3,age);
    ps.setString(4,dob);
    ps.executeUpdate();