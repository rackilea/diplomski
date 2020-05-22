public void load(String fileName) throws ConfigurationException
{
    try
    {
        URL url = ConfigurationUtils.locate(this.fileSystem, basePath, fileName);

        if (url == null)
        {
            throw new ConfigurationException("Cannot locate configuration source " + fileName);
        }
        load(url);
    }
    catch (ConfigurationException e)
    {
        throw e;
    }
    catch (Exception e)
    {
        throw new ConfigurationException("Unable to load the configuration file " + fileName, e);
    }
}