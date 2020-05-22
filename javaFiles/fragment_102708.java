String str="insert into details (type, name,pwd ) 
    values(?,?,?)";
   ps=con.prepareStatement(str); // so no "" around str.
   ps.setString(1,type); // Sets the content of the first ?, all safe against SQL Injection
   ps.setString(2,name); // Sets the content of the second ?
   ps.setString(3,pwd); // Sets the content of the third ?
   ps.execute(); // Execute instead of executeUpdate.