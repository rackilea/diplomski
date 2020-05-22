private void readFileFromInternalStorage() 
{
    String eol = System.getProperty("line.separator");
    BufferedReader input = null;
    try 
    {
        input = new BufferedReader(new InputStreamReader(openFileInput("myfile")));
        String line;
        StringBuffer buffer = new StringBuffer();
        while ((line = input.readLine()) != null) 
        {
            buffer.append(line + eol);
        }
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    } 
    finally 
    {
        if (input != null) 
        {
            try 
            {
                input.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
}