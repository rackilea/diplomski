public static void main(final String[] args) {
    Options options = new Options();
    options.addOption(
        Option.builder("y")
            .required(true)
            .hasArg(true)
            .desc("The year")
            .longOpt("year")
            .build()
    );
    options.addOption(
        Option.builder("m")
            .required(true)
            .desc("The months")
            .numberOfArgs(Option.UNLIMITED_VALUES)
            .longOpt("month")
            .build()
    );
    CommandLineParser parser = new DefaultParser();
    CommandLine cmd;
    try {
        cmd = parser.parse(options, args);
    } catch (ParseException e) {
        System.err.println( "Could not parse the command due to: " + e.getMessage());
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp( "java", options );
        return;
    }
    String year = cmd.getOptionValue("y");
    String[] months = cmd.getOptionValues("m");
    // Rest of your code here
}