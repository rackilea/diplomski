try (Connection con = super.getConnection()) {
        String query = "INSERT INTO \"Workout\" VALUES(?,?,?,?)";
        String query2 = "INSERT INTO Workout_exercise ... ";
        PreparedStatement pstmt = con.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, titel);
        pstmt.setString(2, beschrijving);
        pstmt.setInt(3, persoon_id);
        pstmt.setInt(4, categorie_id);
        pstmt.executeUpdate();
        result = true;

        try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs != null && rs.next()) {
                        workout_pkey = rs.getInt(1);
                        PreparedStatement pstmt2=con.prepareStatement(query2);
                        ...

                        for (Workout_exercise ex: exs) {
                              pstmt2.setInt(1, workout_pkey);
                              ...

                              pstmt2.addBatch();
                        }
                         pstmt2.executeBatch();

           }
       }    
    } catch (SQLException sqle) {
        sqle.printStackTrace();
    }