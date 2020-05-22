String updateQuery = "UPDATE " + USER_TABLE +
                       " SET " + USER_TABLE_FIRST_NAME + "=IFNULL(? ," + USER_TABLE_FIRST_NAME + ")," +
                                 USER_TABLE_LAST_NAME + "=?," +
                                 USER_TABLE_ABOUT_ME + "=?," +
                                 USER_TABLE_CITY + "=?," +
                                 USER_TABLE_DOB + "=?" +
                     " WHERE " + USER_TABLE_ID + "=?";
PreparedStatement stmt = conn.prepareStatement(updateQuery);
stmt.setString(1, user.getFirstName());
stmt.setString(2, user.getLastName());
stmt.setString(3, user.getAboutMe());
stmt.setString(4, user.getCity());
stmt.setString(5, user.getDateOfBirth());
stmt.setString(6, user.getUserId());