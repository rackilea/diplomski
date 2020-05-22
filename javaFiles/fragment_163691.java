protected void processLine(PreparedStatement stmt, String[] line)
        throws SQLException, UnsupportedEncodingException
{
    //this code differs from the rest
      stmt.setString(1, world.getIdentifier());
      stmt.setInt(2, Integer.valueOf(line[0]));
      stmt.setString(3, URLDecoder.decode(line[1], "UTF-8"));
      if ("0".equals(line[2])) {
       stmt.setNull(4, Types.INTEGER);
      } else {
       stmt.setInt(4, Integer.valueOf(line[2]));
      }
}