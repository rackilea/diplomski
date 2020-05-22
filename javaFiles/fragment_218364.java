class MyCSVCompatibilityReader extends BufferedReader
    {
    private final BufferedReader delegate;

    public MyCSVCompatibilityReader(final FileReader fileReader)
        {
        this.delegate = new BufferedReader(fileReader);
        }

    @Override
    public String readLine()
        {
        final String line = this.delegate.readLine();
        if ("".equals(line.trim())
            { return ",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,"; }
        else
            { return line; }
        }
    }