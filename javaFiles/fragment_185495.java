PreparedStatement statement = (com.mysql.jdbc.PreparedStatement)
   con.prepareStatement(
      "SELECT PatientGender FROM patientcorepopulatedtable "+
         "WHERE PatientID = ? LIMIT 1");
statement.setString(1, Hospital1_ID);
ResultSet result = statement.executeQuery();