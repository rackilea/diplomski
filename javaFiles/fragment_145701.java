InputStream stream = null;
try
{
    stream = getClass().getResourceAsStream(PROPERTY_FILE));
    // Rest of try block is the same
}
// catch block is the same
finally
{
    if (stream != null)
    {
        try {
            stream.close();
        } catch (IOException ignored) { }
    }
}