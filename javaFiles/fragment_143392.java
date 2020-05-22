PreparedStatement ps = con.prepareStatement("INSERT INTO registration_table(name,address) VALUES (?, ?)");   

  for(Employee employee: employees){
      ps.setString(1,employee.getName());
      ps.setString(2,employee.getAddress());
      ps.addBatch();// add to batch
      ps.clearParameters();
  }

  int[] results = ps.executeBatch();// execute with batch rather than execute many SQL separately.