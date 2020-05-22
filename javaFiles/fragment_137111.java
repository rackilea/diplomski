private String getNextQuote()
{
    String returnValue = null;
    try
    {
        if ((returnValue = qfs.readLine()) == null)
        {
            qfs.close();
            this.openInputFile();
            returnValue = qfs.readLine();
        }
    }
    catch (IOException e)
    {
        returnValue = "IOException occurred in server.";
    }
    return returnValue;
}