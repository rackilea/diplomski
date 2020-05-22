@Override
public UserDetails fetchUserById(int userId) {
    String query = "select ID, LOGIN_ID, EMAIL_ID, FIRST_NAME, MIDDLE_NAME, LAST_NAME, " 
                   + " decode(is_primary, 1, 'true', 'false') IS_PRIMARY, " 
                   + " decode(status, 1, 'true', 'false') IS_ACTIVE "
                   + " from user_details where ID = ?";
    try{
        RowMapper<UserDetails> rowMapper = new RowMapper<UserDetails>(){
            @Override
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDetails userDetails = new UserDetails ();
                userDetails .setId(rs.getInt("ID"));
                userDetails .setIntranetId(rs.getString("LOGIN_ID"));
                userDetails .setEmailId(rs.getString("EMAIL_ID"));
                userDetails .setFirstName(rs.getString("FIRST_NAME"));
                userDetails .setMiddleName(rs.getString("MIDDLE_NAME"));
                userDetails .setLastName(rs.getString("LAST_NAME"));
                userDetails.setPrimaryAnalyst(Boolean.valueOf(rs.getString("IS_PRIMARY")));
                userDetails.setStatus(Boolean.valueOf(rs.getString("IS_ACTIVE")));
                return userDetails;
            };
            return jdbcTemplate.queryForObject(query, rowMapper, userId);
        }
    }catch(EmptyResultDataAccessException e){
        UserDetails userDetails = new UserDetails ();
        //fill the userDetails fields with the empty values
        return userDetails;
    }
}