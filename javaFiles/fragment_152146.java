private static void readWithCsvDozerBeanReader (final Reader reader) throws IOException
{
    ICsvDozerBeanReader beanReader = null;
    try
    {
        beanReader = new CsvDozerBeanReader(reader, PREFS);

        final String[] header = beanReader.getHeader(true);

        // set up the field mapping, processors and hints dynamically
        final String[] fieldMapping = new String[header.length];
        final CellProcessor[] processors = new CellProcessor[header.length];
        final Class<?>[] hintTypes = new Class<?>[header.length];
        for (int i = 0; i < header.length; i++)
        {
            fieldMapping[i] = header[i];
            if (header[i].equals("firstname"))
            {
                processors[i] = new NotNull();
            }
            if (header[i].equals("height") || header[i].equals("weight"))
            {
                processors[i] = new ParseInt();
            }
        }

        beanReader.configureBeanMapping(Person.class, fieldMapping, hintTypes);

        Person person;
        while ((person = beanReader.read(Person.class, processors)) != null)
        {
            System.out.println(String.format("lineNo=%s, rowNo=%s, person=%s", beanReader.getLineNumber(),
                    beanReader.getRowNumber(), person));
        }

    }
    finally
    {
        if (beanReader != null)
        {
            beanReader.close();
        }
    }
}