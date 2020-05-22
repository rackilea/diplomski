ResultSet rs = statement.executeQuery("Select clob_column from table_name name ...");
Reader in = rs.getCharacterStream(1);
String clobValue = null;
if (!rs.wasNull())
{
   // process whatever the Reader returns, e.g. using Apache Commons IO
   clobValue = IOUtils.toString(in);
}
in.close();