protected abstract void processLine(PreparedStatement stmt, String[] line)
    throws SQLException, UnsupportedEncodingException;

public void parse() throws SQLException
{
 InputStream in = getStream(world.getUrl(), true, Configuration.GET_PLAYER_COMPRESSED);
 Scanner sc = new Scanner(in);
 PreparedStatement stmt = con.prepareStatement(SQL_UPDATE_PLAYER);

 String[] line;
 int i = 0;
 while (sc.hasNextLine()) {
   try {
       line = sc.nextLine().split(",");

     {
         processLine(stmt, line);
     }
     stmt.addBatch();
     if (++i >= 1000) {
         stmt.executeBatch(); //execute batch every 1000 entries
         i=0;
     }
   } catch (Exception e) {
       e.printStackTrace();
   }
 }
 stmt.executeBatch();
 stmt.close();
 sc.close();
 }