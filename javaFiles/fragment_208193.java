public List<String> checkSeat(String no) throws Exception {
          ...
              try (Connection conn = db.getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);) 
              {
              ps.setString(1, no);
              ResultSet rs = ps.executeQuery()            
              while (rs.next()) {
                 seat.add(rs.getString("selected_seat"));
              }
           }
           return seat;
    }