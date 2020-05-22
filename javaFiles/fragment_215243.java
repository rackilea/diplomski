PreparedStatement insertUrlStatement = con.prepareStatement("INSERT INTO urls VALUES(?, ?, ?, ?)");
//Replace the **first** "?" by an "id" variable content (containing an **int**)
insertUrlStatement.setInt(1, id);
//Replace the **second** "?" by the "url" variable content (containing a **String**)
insertUrlStatement.setString(2, url);
//Two other setXxx();
insertUrlStatement.executeUpdate()