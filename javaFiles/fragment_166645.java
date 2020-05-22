private static String fixFileName(String filename)
{
    String[] sArray = filename.split("\\s+");
    String retval = "";
    for (String s : sArray)
    {
        if (s.trim().equals(""))
        {
            s = String.valueOf(System.currentTimeMillis());
        }
        retval += s;
    }

    return retval;
}