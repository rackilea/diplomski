StringReader reader = new StringReader(userAbout);
PreparedStatement insertClob = dbCon.prepareStatement("UPDATE user_data SET user_about=? WHERE user_id=?");
insertClob.setCharacterStream(1, reader, userAbout.length());
insertClob.setInt(2,userId);

int count= insertClob.executeUpdate();