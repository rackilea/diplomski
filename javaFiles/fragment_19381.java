Options options = createOptions();
CommandLineParser parser = new GnuParser();
CommandLine cmdLine;
int timeoutHumanMove;
try
{
    cmdLine = parser.parse(options, args, true);
    timeoutHumanMove = getTimeoutOption(cmdLine, "thm", 300);
}
catch(ParseException e)
{
    return;
}

private static int getTimeoutOption(CommandLine cmdLine, String opt, int defaultSeconds)
    throws ParseException
{
    if(cmdLine.hasOption(opt))
    {
        Number val = (Number)cmdLine.getParsedOptionValue(opt);
        return (int)(val.doubleValue() * 1000D);
    } else
    {
        return 1000 * defaultSeconds;
    }
}

private static Options createOptions()
{
    Options options = new Options();
    options.addOption(OptionBuilder.withDescription("print this help and exit").create(OptionBuilder.withLongOpt("help"), 104));

    // ...
    return options;
}