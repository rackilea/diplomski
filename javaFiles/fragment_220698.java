private void standardClassFunction()
{
    try
    {
        String temp = null;
        Log.v(TAG, temp.toString()); //This will throw the exception as its null
    }
    catch (Exception ex)
    {
        throw ex; //Don't handle the exception, throw the exception backto the calling method
    }
}