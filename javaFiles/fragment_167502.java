private String getName(
  int id
  ) throws EOFException, UnsupportedEncodingException
{
  // Naming Table ('name' table).
  Integer tableOffset = tableOffsets.get("name");
  if(tableOffset == null)
    throw new ParseException("'name' table does NOT exist.");