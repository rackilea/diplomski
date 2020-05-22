protected String getJSONFromInputStream(InputStream is)
{
    if (is == null)
        throw new NullPointerException();
    //instantiates a reader with max size
    BufferedReader reader = new BufferedReader(new InputStreamReader(is), 8 * 1024);

    StringBuilder sb = new StringBuilder();

    try
    {
        //reads the response line by line (and separates by a line-break)
        String line;
        while ((line = reader.readLine()) != null)
        {
            sb.append(line + "\n");
        }
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    finally
    {
        try
        {
            //closes the inputStream
            is.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    return sb.toString();
}