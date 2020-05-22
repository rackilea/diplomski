private String readFile(String path) throws IOException
{
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new FileReader(path));
    try
    {
        String line = null;
        while ((line = br.readLine())!=null)
        {
            sb.append(line);
        }
    }
    finally
    {
        br.close();
    }
    return sb.toString();
}