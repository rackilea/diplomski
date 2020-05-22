public class PropertiesConfigurationLayoutExtended extends PropertiesConfigurationLayout{

    public PropertiesConfigurationLayoutExtended(PropertiesConfigurationExtended config) {
        super(config);
    }
    public void save(Writer out) throws ConfigurationException
    {
        try
        {
            char delimiter = getConfiguration().isDelimiterParsingDisabled() ? 0
                    : getConfiguration().getListDelimiter();
            PropertiesConfigurationExtended.PropertiesWriter writer = new PropertiesConfigurationExtended.PropertiesWriter(
                    out, delimiter);
            if (getHeaderComment() != null)
            {
                writer.writeln(getCanonicalHeaderComment(true));
                writer.writeln(null);
            }

            for (Iterator it = getKeys().iterator(); it.hasNext();)
            {
                String key = (String) it.next();
                if (getConfiguration().containsKey(key))
                {
                    // Output blank lines before property
                    for (int i = 0; i < getBlancLinesBefore(key); i++)
                    {
                        writer.writeln(null);
                    }
                    // Output the comment
                    if (getComment(key) != null)
                    {
                        writer.writeln(getCanonicalComment(key, true));
                    }
                    // Output the property and its value
                    boolean singleLine = (isForceSingleLine() || isSingleLine(key))
                            && !getConfiguration().isDelimiterParsingDisabled();
                    writer.writeProperty(key, getConfiguration().getProperty(
                            key), singleLine);
                }
            }
            writer.flush();
        }
        catch (IOException ioex)
        {
            throw new ConfigurationException(ioex);
        }
    }
}