String sql1 = "INSERT INTO table(col2, col3) VALUES(?, ?)";
try (PreparedStatement pst1 = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS))) {
     int updateCount = pst1.executeUpdate();
     if (updateCount != 0) { // Records inserted?
         int res_id = 0; // Key
         try (ResultSet generatedKeysRS = pst1.getGeneratedKeys()) {
              if (generatedKeysRS.next()) {
                  res_id = generatedKeysRS.getInt(1);
              }
         }
     }
 }