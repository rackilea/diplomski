public static String lineNumbers(String x) throws IOException
{
    LineNumberReader lineReader = new LineNumberReader(new FileReader("/Users/alfasi/tpstats-eu-west-1.log"));
    String numbers = "";
    String line;
    while ((line = lineReader.readLine()) != null)
    {
        if (line.contains(x))
        {
            numbers += "," + lineReader.getLineNumber();
        }
    }
    return "[" + numbers.substring(1) + "]";
}