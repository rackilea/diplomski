public void load(URL url) throws ConfigurationException
{
    if (sourceURL == null)
    {
        if (StringUtils.isEmpty(getBasePath()))
        {
            // ensure that we have a valid base path
            setBasePath(url.toString());
        }
        sourceURL = url;
    }

    InputStream in = null;

    try
    {
        in = fileSystem.getInputStream(url);
        load(in);
    }
    catch (ConfigurationException e)
    {
        throw e;
    }
    catch (Exception e)
    {
        throw new ConfigurationException("Unable to load the configuration from the URL " + url, e);
    }
    finally
    {
        // close the input stream
        try
        {
            if (in != null)
            {
                in.close();
            }
        }
        catch (IOException e)
        {
            getLogger().warn("Could not close input stream", e);
        }
    }
}