String sql;  
  while(rs.next()) {
      String rPredicates = rs.getString("predicates").split(",");
      sql = "SELECT *, " + rs.getString("id") + " FROM table_x WHERE "
      sql += rPredicates[0];
      for(int ndx=1; ndx< rPredicates.length; ndx++) {
        sql += " or " + rPredicates[ndx];
      }
      sql += " union ";
    }