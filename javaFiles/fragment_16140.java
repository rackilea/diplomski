private String getInputString() throws IOException
{
    InputStream is = request.getInputStream();
    if (is != null)
    {

        Writer writer = new StringWriter();

        char[] buffer = new char[request.getContentLength()];

        try
        {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            int n;
            while ((n = reader.read(buffer)) != -1)
            {
                writer.write(buffer, 0, n);
            }
        }
        finally
        {
            is.close();
        }
        return writer.toString();
    }
    else
    {
        return "";
    }
}