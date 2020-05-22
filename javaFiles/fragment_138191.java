private static void generateCsvFile(String sFileName) {
try
  {
  FileWriter writer = new FileWriter(sFileName);

  // Start a row
  writer.append("Column1");
  writer.append(',');
  writer.append("Column2");
  writer.append('\n');
  // Start a new row
  writer.append("Row2Column1");
  writer.append(',');
  writer.append("Row2Column2");
  writer.append('\n');

  writer.flush();
  writer.close();
}
catch(IOException e)
{
  e.printStackTrace();
}