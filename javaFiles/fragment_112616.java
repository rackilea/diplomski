public void load() throws ConfigurationException
{
    if (sourceURL != null)
    {
        load(sourceURL);
    }
    else
    {
        load(getFileName());
    }
}