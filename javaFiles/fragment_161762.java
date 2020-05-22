for (.... whatever ...)
{
    try
    {
        something
    }
    catch(Exception e)
    {
        obj.put("message",e.getMessage());
    }
}