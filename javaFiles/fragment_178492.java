jdbcTemplate.query(
      query, 
      ps -> { 
         ps.setInt(1, userId);
         ps.setFetchSize(500);
      },
      rs -> { ... }
);