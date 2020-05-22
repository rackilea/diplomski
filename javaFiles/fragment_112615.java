public AbstractFileConfiguration(File file) throws ConfigurationException
{
    this();

    // set the file and update the url, the base path and the file name
    setFile(file);

    // load the file
    if (file.exists())
    {
        load(); // method which interest you
    }
}