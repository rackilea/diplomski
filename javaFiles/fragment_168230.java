private void writeFileToInternalStorage() 
{
    String eol = System.getProperty("line.separator");
    BufferedWriter writer = null;
    try 
    {
      writer = new BufferedWriter(new OutputStreamWriter(openFileOutput("myfile", MODE_WORLD_WRITEABLE)));
      writer.write("This is a test1." + eol);
      writer.write("This is a test2." + eol);
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    } 
    finally 
    {
      if (writer != null) 
      {
        try 
        {
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
      }
    }
}