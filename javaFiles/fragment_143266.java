String sql = "insert into table1(name,address,city,state,zip) values(?,?,?,?,?)";
PreparedStatement preparedstatement
= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

//....

preparedstatement.setString(1,name);
preparedstatement.setString(2,address);
preparedstatement.setString(3,city);
preparedstatement.setString(4,state);
preparedstatement.setString(5,zip);

preparedstatement.executeUpdate();

ResultSet generatedKeys = preparedstatement.getGeneratedKeys();
//....