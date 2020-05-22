String query = "INSERT INTO PhoneNums  VALUES (?, ?, ?)";
ps = connection.prepareStatement(query);
ps.setString(1, surname);
ps.setString(2, forenames);
ps.setString(3, telNum);
ps.executeUpdate();


// I believe all these three are strings