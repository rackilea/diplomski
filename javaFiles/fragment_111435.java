public static String[] getStringArray(String filename)
{
    try
    {
        String content = IOUtils.toString(new FileInputStream(filename), Charset.defaultCharset());
        String[] lines = content.split("(\\\\n|\\r?\\n)");
        return lines;
    } catch (IOException ex)
    {
        Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}