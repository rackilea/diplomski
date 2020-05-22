return jdbc.query("select pest_name, count(pest_name) as pest_count from sighting group by pest_name", new RowMapper<Sighting>() {
         public Sighting mapRow(ResultSet rs, int rowNum) throws SQLException {
                Sighting sighting = new Sighting();
                sighting.setCount(rs.getInt("pest_count"));
                sighting.setPest_name(rs.getString("pest_name"));
                return sighting;
            }      
       });