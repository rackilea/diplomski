List<String> data = getJdbcTemplate().query(query, new RowMapper<String>(){
                            public String mapRow(ResultSet rs, int rowNum) 
                                                         throws SQLException {
                                    return rs.getString(1);
                            }
                       });